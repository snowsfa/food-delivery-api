package com.food.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {

	private static final long serialVersionUID = -9014912817951792585L;

	public CustomerNotFoundException(Long id) {
		super(String.format("Customer not found with id %s.", id));
	}
	
	public CustomerNotFoundException(String email) {
		super(String.format("Customer not found with email '%s'.", email));
	}	  	  
}
