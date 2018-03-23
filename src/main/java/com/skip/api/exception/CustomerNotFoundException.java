package com.skip.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CustomerNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CustomerNotFoundException(long customerId) {
		super(String.format("Customer not found with id %s.", customerId));
	}
	
}
