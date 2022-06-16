package it.uniroma3.siw.demo.controller;

import java.util.List;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import it.uniroma3.siw.demo.controller.validator.BuffetValidator;
import it.uniroma3.siw.demo.model.Buffet;
import it.uniroma3.siw.demo.service.BuffetService;

@Controller
public class BuffetController {

	@Autowired
	private BuffetService service;
	
	@Autowired
	private BuffetValidator validator;
	
	@GetMapping("/buffetForm")
	public String getBuffet(Model model) {
		model.addAttribute("buffet", new Buffet());
		return "buffetForm.html";
	}
	
	@PostMapping("/buffet")
	public String addBuffet(@Valid @ModelAttribute("buffet") Buffet buffet, BindingResult binding, Model model) {
		validator.validate(buffet, binding);
		if(!binding.hasErrors()) {
			service.save(buffet);
			model.addAttribute("buffet", buffet);
			return "buffet.html";
		}
		else return "buffetForm.html";
	}
	
	@GetMapping("/buffets")
	public String getBuffets(Model model) {
		List<Buffet> buffets = service.findAll();
		model.addAttribute("buffets", buffets);
		return "buffets.html";
	}
	
	@GetMapping("/buffet/{id}")
	public String getBuffet(@PathVariable("id") Long id, Model model) {
		Buffet buffet = service.findById(id);
		model.addAttribute("buffet", buffet);
		return "buffet.html";
	}
	
	@GetMapping("/toUpdateBuffet")
	public String toUpdateBuffet(Model model) {
		return "toUpdateBuffet.html";
	}
	
	@GetMapping("/toDeleteBuffet/{id}")
	public String toDeleteBuffet(@PathVariable("id") Long id, Model model) {
		Buffet buffet = service.findById(id);
		model.addAttribute("buffet", buffet);
		return "toDeleteBuffet.html";
	}
	
	@Transactional
	@GetMapping("/deleteBuffet/{id}")
	public String deleteBuffet(@PathVariable("id") Long id, Model model) {
		this.service.delete(id);
		List<Buffet> buffets = service.findAll();
		model.addAttribute("buffets", buffets);
		return "buffets.html";
	}
	
}
