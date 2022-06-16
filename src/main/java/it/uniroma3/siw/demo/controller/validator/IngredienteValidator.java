package it.uniroma3.siw.demo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.demo.model.Ingrediente;
import it.uniroma3.siw.demo.service.IngredienteService;

@Component
public class IngredienteValidator implements Validator {
	
	@Autowired 
	private IngredienteService ingredienteService;
	
	@Override
	public boolean supports(Class<?> iClass) {
		return Ingrediente.class.equals(iClass);
	}

	@Override
	public void validate(Object i, Errors errors) {
		if(ingredienteService.alreadyExists((Ingrediente) i)) {
			errors.reject("ingrediente.duplicato");
		}
	}

}