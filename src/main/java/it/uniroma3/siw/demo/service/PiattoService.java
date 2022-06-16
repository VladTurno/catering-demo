package it.uniroma3.siw.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demo.model.Piatto;
import it.uniroma3.siw.demo.repository.PiattoRepository;

@Service
public class PiattoService {
	
	@Autowired
	private PiattoRepository repository;

	@Transactional
	public void save(Piatto p) {
		repository.save(p);
	}
	
	@Transactional
	public void delete(Piatto p) {
		repository.delete(p);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Piatto findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Piatto> findAll() {
		List<Piatto> piatti = new ArrayList<Piatto>();
		for(Piatto p : repository.findAll())
			piatti.add(p);
		return piatti;
	}
	
	public boolean alreadyExists(Piatto p) {
		return repository.existsByNomeAndDescrizione(p.getNome(), p.getDescrizione());
	}
	
}
