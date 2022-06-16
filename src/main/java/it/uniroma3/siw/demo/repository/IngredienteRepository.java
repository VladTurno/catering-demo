package it.uniroma3.siw.demo.repository;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.demo.model.Ingrediente;

public interface IngredienteRepository extends CrudRepository<Ingrediente, Long> {
	
	public boolean existsByNomeAndOrigineAndDescrizione(String nome, String origine, String descrizione);
	
	public void deleteById(Long id);
	
}