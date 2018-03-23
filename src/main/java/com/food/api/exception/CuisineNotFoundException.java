package com.food.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CuisineNotFoundException extends Exception {

	private static final long serialVersionUID = 697871964225629504L;

	public CuisineNotFoundException(Long id) {
		super(String.format("Cuisine not found with id %s.", id));
	}
	  	  
}
