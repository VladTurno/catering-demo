package it.uniroma3.siw.demo.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.demo.model.Buffet;
import it.uniroma3.siw.demo.model.Chef;

public interface BuffetRepository extends CrudRepository<Buffet, Long> {
	
	public boolean existsByNomeAndDescrizioneAndChef(String nome, String descrizione, Chef chef);
	
	public void deleteById(Long id);
	
}