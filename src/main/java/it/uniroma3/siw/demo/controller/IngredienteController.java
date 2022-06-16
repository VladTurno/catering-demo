package it.uniroma3.siw.demo.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw.demo.controller.validator.IngredienteValidator;
import it.uniroma3.siw.demo.model.Ingrediente;
import it.uniroma3.siw.demo.service.IngredienteService;

@Controller
public class IngredienteController {

	@Autowired
	private IngredienteService service;
	
	@Autowired
	private IngredienteValidator validator;
	
	@GetMapping("/ingredienteForm")
	public String getIngrediente(Model model) {
		model.addAttribute("ingrediente", new Ingrediente());
		return "ingredienteForm.html";
	}
	
	@PostMapping("/ingrediente")
	public String addIngrediente(@Valid @ModelAttribute("ingrediente") Ingrediente ingrediente, BindingResult binding, Model model) {
		validator.validate(ingrediente, binding);
		if(!binding.hasErrors()) {
			service.save(ingrediente);
			model.addAttribute("ingrediente", ingrediente);
			return "ingrediente.html";
		}
		else return "ingredienteForm.html";
	}
	
	@GetMapping("/ingredienti")
	public String getIngredienti(Model model) {
		List<Ingrediente> ingredienti = service.findAll();
		model.addAttribute("ingredienti", ingredienti);
		return "ingredienti.html";
	}
	
	@GetMapping("/ingrediente/{id}")
	public String getIngrediente(@PathVariable("id") Long id, Model model) {
		Ingrediente ingrediente = service.findById(id);
		model.addAttribute("ingrediente", ingrediente);
		return "ingrediente.html";
	}
	
	@GetMapping("/toUpdateIngrediente")
	public String toUpdateIngrediente(Model model) {
		return "toUpdateIngrediente.html";
	}
	
	@GetMapping("/toDeleteIngrediente/{id}")
	public String toDeleteIngrediente(@PathVariable("id") Long id, Model model) {
		Ingrediente ingrediente = service.findById(id);
		model.addAttribute("ingrediente", ingrediente);
		return "toDeleteIngrediente.html";
	}
	
	@Transactional
	@GetMapping("/deleteIngrediente/{id}")
	public String deleteIngrediente(@PathVariable("id") Long id, Model model) {
		this.service.delete(id);
		List<Ingrediente> ingredienti = service.findAll();
		model.addAttribute("ingredienti", ingredienti);
		return "ingredienti.html";
	}
	
}
