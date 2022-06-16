package it.uniroma3.siw.demo.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw.demo.controller.validator.ChefValidator;
import it.uniroma3.siw.demo.model.Chef;
import it.uniroma3.siw.demo.service.ChefService;

@Controller
public class ChefController {

	@Autowired
	private ChefService service;
	
	@Autowired
	private ChefValidator validator;
	
	@GetMapping("/chefForm")
	public String getChef(Model model) {
		model.addAttribute("chef", new Chef());
		return "chefForm.html";
	}
	
	@PostMapping("/chef")
	public String addChef(@Valid @ModelAttribute("chef") Chef chef, BindingResult binding, Model model) {
		validator.validate(chef, binding);
		if(!binding.hasErrors()) {
			service.save(chef);
			model.addAttribute("chef", chef);
			return "chef.html";
		}
		else return "chefForm.html";
	}
	
	@GetMapping("/chefs")
	public String getChefs(Model model) {
		List<Chef> chefs = service.findAll();
		model.addAttribute("chefs", chefs);
		return "chefs.html";
	}
	
	@GetMapping("/chef/{id}")
	public String getChef(@PathVariable("id") Long id, Model model) {
		Chef chef = service.findById(id);
		model.addAttribute("chef", chef);
		return "chef.html";
	}
	
	@GetMapping("/updateChef/{id}")
	public String updateChef(@PathVariable("id") Long id, Model model) {
		Chef chef = service.findById(id);
		model.addAttribute("chef", chef);
		return "chef.html";
	}
	
	@GetMapping("/toDeleteChef/{id}")
	public String toDeleteChef(@PathVariable("id") Long id, Model model) {
		Chef chef = service.findById(id);
		model.addAttribute("chef", chef);
		return "toDeleteChef.html";
	}
	
	@Transactional
	@GetMapping("/deleteChef/{id}")
	public String deleteChef(@PathVariable("id") Long id, Model model) {
		this.service.delete(id);
		List<Chef> chefs = service.findAll();
		model.addAttribute("chefs", chefs);
		return "chefs.html";
	}
	
}
