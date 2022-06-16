package it.uniroma3.siw.demo.controller.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import it.uniroma3.siw.demo.model.Chef;
import it.uniroma3.siw.demo.service.ChefService;

@Component
public class ChefValidator implements Validator {
	
	@Autowired 
	private ChefService chefService;
	
	@Override
	public boolean supports(Class<?> cClass) {
		return Chef.class.equals(cClass);
	}

	@Override
	public void validate(Object c, Errors errors) {
		if(chefService.alreadyExists((Chef) c)) {
			errors.reject("chef.duplicato");
		}
	}

}
