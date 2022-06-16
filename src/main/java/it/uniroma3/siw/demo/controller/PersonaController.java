package it.uniroma3.siw.demo.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw.demo.controller.validator.PersonaValidator;
import it.uniroma3.siw.demo.model.Persona;
import it.uniroma3.siw.demo.service.PersonaService;

@Controller
public class PersonaController {

	@Autowired
	private PersonaService service;
	
	@Autowired
	private PersonaValidator validator;
	
	@GetMapping("/personaForm")
	public String getPersona(Model model) {
		model.addAttribute("persona", new Persona());
		return "personaForm.html";
	}
	
	@PostMapping("/persona")
	public String addPersona(@Valid @ModelAttribute("persona") Persona persona, BindingResult binding, Model model) {
		validator.validate(persona, binding);
		if(!binding.hasErrors()) {
			service.save(persona);
			model.addAttribute("persona", persona);
			return "persona.html";
		}
		else return "personaForm.html";
	}
	
	@GetMapping("/persone")
	public String getPersone(Model model) {
		List<Persona> persone = service.findAll();
		model.addAttribute("persone", persone);
		return "persone.html";
	}
	
	@GetMapping("/persona/{id}")
	public String getPersona(@PathVariable("id") Long id, Model model) {
		Persona persona = service.findById(id);
		model.addAttribute("persona", persona);
		return "persona.html";
	}
	
	@GetMapping("/updatePersona/{id}")
	public String updatePersona(@PathVariable("id") Long id, Model model) {
		Persona persona = service.findById(id);
		model.addAttribute("persona", persona);
		return "persona.html";
	}
	
	@GetMapping("/toDeletePersona/{id}")
	public String toDeletePersona(@PathVariable("id") Long id, Model model) {
		Persona persona = service.findById(id);
		model.addAttribute("persona", persona);
		return "toDeletePersona.html";
	}
	
	@Transactional
	@GetMapping("/deletePersona/{id}")
	public String deletePersona(@PathVariable("id") Long id, Model model) {
		this.service.delete(id);
		List<Persona> persone = service.findAll();
		model.addAttribute("persone", persone);
		return "persone.html";
	}
	
}
