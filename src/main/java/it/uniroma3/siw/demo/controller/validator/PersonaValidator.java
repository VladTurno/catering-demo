package it.uniroma3.siw.demo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.demo.model.Persona;
import it.uniroma3.siw.demo.service.PersonaService;

@Component
public class PersonaValidator implements Validator {
	
	@Autowired 
	private PersonaService personaService;
	
	@Override
	public boolean supports(Class<?> pClass) {
		return Persona.class.equals(pClass);
	}

	@Override
	public void validate(Object p, Errors errors) {
		if(personaService.alreadyExists((Persona) p)) {
			errors.reject("persona.duplicato");
		}
	}

}
