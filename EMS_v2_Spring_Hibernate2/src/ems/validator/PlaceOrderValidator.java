package ems.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class PlaceOrderValidator implements Validator{

	@Override
	public boolean supports(Class arg0) {
		
		return false;
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		// TODO Auto-generated method stub
		
	}

}
