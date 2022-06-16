package it.uniroma3.siw.demo.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw.demo.controller.validator.PiattoValidator;
import it.uniroma3.siw.demo.model.Piatto;
import it.uniroma3.siw.demo.service.PiattoService;

@Controller
public class PiattoController {

	@Autowired
	private PiattoService service;
	
	@Autowired
	private PiattoValidator validator;
	
	@GetMapping("/piattoForm")
	public String getPiatto(Model model) {
		model.addAttribute("piatto", new Piatto());
		return "piattoForm.html";
	}
	
	@PostMapping("/piatto")
	public String addPiatto(@Valid @ModelAttribute("piatto") Piatto piatto, BindingResult binding, Model model) {
		validator.validate(piatto, binding);
		if(!binding.hasErrors()) {
			service.save(piatto);
			model.addAttribute("piatto", piatto);
			return "piatto.html";
		}
		else return "piattoForm.html";
	}
	
	@GetMapping("/piatti")
	public String getPiatti(Model model) {
		List<Piatto> piatti = service.findAll();
		model.addAttribute("piatti", piatti);
		return "piatti.html";
	}
	
	@GetMapping("/piatto/{id}")
	public String getPiatto(@PathVariable("id") Long id, Model model) {
		Piatto piatto = service.findById(id);
		model.addAttribute("piatto", piatto);
		return "piatto.html";
	}
	
	@GetMapping("/updatePiatto/{id}")
	public String updatePiatto(@PathVariable("id") Long id, Model model) {
		Piatto piatto = service.findById(id);
		model.addAttribute("piatto", piatto);
		return "piatto.html";
	}
	
	@GetMapping("/toDeletePiatto/{id}")
	public String toDeletePiatto(@PathVariable("id") Long id, Model model) {
		Piatto piatto = service.findById(id);
		model.addAttribute("piatto", piatto);
		return "toDeletePiatto.html";
	}
	
	@Transactional
	@GetMapping("/deletePiatto/{id}")
	public String deletePiatto(@PathVariable("id") Long id, Model model) {
		this.service.delete(id);
		List<Piatto> piatti = service.findAll();
		model.addAttribute("piatti", piatti);
		return "piatti.html";
	}
	
}
