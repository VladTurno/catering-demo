package it.uniroma3.siw.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demo.model.Chef;
import it.uniroma3.siw.demo.repository.ChefRepository;

@Service
public class ChefService {
	
	@Autowired
	private ChefRepository repository;

	@Transactional
	public void save(Chef c) {
		repository.save(c);
	}
	
	@Transactional
	public void delete(Chef c) {
		repository.delete(c);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Chef findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Chef> findAll() {
		List<Chef> chefs = new ArrayList<Chef>();
		for(Chef c : repository.findAll())
			chefs.add(c);
		return chefs;
	}
	
	public boolean alreadyExists(Chef c) {
		return repository.existsByNomeAndCognomeAndNazionalita(c.getNome(), c.getCognome(), c.getNazionalita());
	}
	
}
