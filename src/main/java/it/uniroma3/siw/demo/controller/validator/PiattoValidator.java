package it.uniroma3.siw.demo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.demo.model.Piatto;
import it.uniroma3.siw.demo.service.PiattoService;

@Component
public class PiattoValidator implements Validator {
	
	@Autowired 
	private PiattoService piattoService;
	
	@Override
	public boolean supports(Class<?> pClass) {
		return Piatto.class.equals(pClass);
	}

	@Override
	public void validate(Object p, Errors errors) {
		if(piattoService.alreadyExists((Piatto) p)) {
			errors.reject("piatto.duplicato");
		}
	}

}