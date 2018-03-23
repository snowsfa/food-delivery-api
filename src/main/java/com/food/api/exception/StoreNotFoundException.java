package com.food.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StoreNotFoundException extends Exception {

	private static final long serialVersionUID = 8740578093137293653L;

	public StoreNotFoundException(Long id) {
		super(String.format("Store not found with id %s.", id));
	}
  	  
}
