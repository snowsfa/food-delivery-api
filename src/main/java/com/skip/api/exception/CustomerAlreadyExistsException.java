package com.skip.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CONFLICT)
public class CustomerAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CustomerAlreadyExistsException(String email) {
		super(String.format("Customer already exists with email %s.", email));
	}
	
}
