package com.skip.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class StoreNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public StoreNotFoundException(long storeId) {
		super(String.format("Store not found with id %s.", storeId));
	}
	
}
