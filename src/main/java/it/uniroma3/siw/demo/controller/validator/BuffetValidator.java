package it.uniroma3.siw.demo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.demo.model.Buffet;
import it.uniroma3.siw.demo.service.BuffetService;

@Component
public class BuffetValidator implements Validator {
	
	@Autowired 
	private BuffetService buffetService;
	
	@Override
	public boolean supports(Class<?> bClass) {
		return Buffet.class.equals(bClass);
	}

	@Override
	public void validate(Object b, Errors errors) {
		if(buffetService.alreadyExists((Buffet) b)) {
			errors.reject("buffet.duplicato");
		}
	}

}