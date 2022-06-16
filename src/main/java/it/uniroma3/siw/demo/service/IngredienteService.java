package it.uniroma3.siw.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demo.model.Ingrediente;
import it.uniroma3.siw.demo.repository.IngredienteRepository;

@Service
public class IngredienteService {
	
	@Autowired
	private IngredienteRepository repository;

	@Transactional
	public void save(Ingrediente i) {
		repository.save(i);
	}
	
	@Transactional
	public void delete(Ingrediente i) {
		repository.delete(i);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Ingrediente findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Ingrediente> findAll() {
		List<Ingrediente> ingredienti = new ArrayList<Ingrediente>();
		for(Ingrediente i : repository.findAll())
			ingredienti.add(i);
		return ingredienti;
	}
	
	public boolean alreadyExists(Ingrediente i) {
		return repository.existsByNomeAndOrigineAndDescrizione(i.getNome(), i.getOrigine(), i.getDescrizione());
	}
	
}
