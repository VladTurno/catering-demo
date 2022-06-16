package it.uniroma3.siw.demo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.demo.model.Buffet;
import it.uniroma3.siw.demo.repository.BuffetRepository;

@Service
public class BuffetService {
	
	@Autowired
	private BuffetRepository repository;

	@Transactional
	public void save(Buffet b) {
		repository.save(b);
	}
	
	@Transactional
	public void delete(Buffet b) {
		repository.delete(b);
	}
	
	@Transactional
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public Buffet findById(Long id) {
		return repository.findById(id).get();
	}
	
	public List<Buffet> findAll() {
		List<Buffet> buffets = new ArrayList<Buffet>();
		for(Buffet b : repository.findAll())
			buffets.add(b);
		return buffets;
	}
	
	public boolean alreadyExists(Buffet b) {
		return repository.existsByNomeAndDescrizioneAndChef(b.getNome(), b.getDescrizione(), b.getChef());
	}
	
}
