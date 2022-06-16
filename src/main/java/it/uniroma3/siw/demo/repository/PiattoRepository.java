package it.uniroma3.siw.demo.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.demo.model.Piatto;

public interface PiattoRepository extends CrudRepository<Piatto, Long> {
	
	public boolean existsByNomeAndDescrizione(String nome, String descrizione);
	
	public void deleteById(Long id);
	
}
