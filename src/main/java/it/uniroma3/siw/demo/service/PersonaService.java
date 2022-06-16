package it.uniroma3.siw.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demo.model.Persona;
import it.uniroma3.siw.demo.repository.PersonaRepository;

@Service
public class PersonaService {
	
	@Autowired
	private PersonaRepository repository;

	@Transactional
	public void save(Persona p) {
		repository.save(p);
	}
	
	@Transactional
	public void delete(Persona p) {
		repository.delete(p);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Persona findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Persona> findAll() {
		List<Persona> persone = new ArrayList<Persona>();
		for(Persona p : repository.findAll())
			persone.add(p);
		return persone;
	}
	
	public boolean alreadyExists(Persona p) {
		return repository.existsByNomeAndCognomeAndEta(p.getNome(), p.getCognome(), p.getEta());
	}
	
}
