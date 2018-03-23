package com.skip.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CuisineNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CuisineNotFoundException(long cuisineId) {
		super(String.format("Cuisine not found with id %s.", cuisineId));
	}
	
}
