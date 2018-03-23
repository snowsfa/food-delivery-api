package com.food.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CustomerAlreadyExistsException extends Exception {

	private static final long serialVersionUID = -1930705635290469920L;
	
	public CustomerAlreadyExistsException(String email) {
		super(String.format("Customer already exists with email '%s'.", email));
	}
	
}
