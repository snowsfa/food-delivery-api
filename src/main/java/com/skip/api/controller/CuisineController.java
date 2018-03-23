package com.skip.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skip.api.domain.Cuisine;
import com.skip.api.domain.Store;
import com.skip.api.exception.CuisineNotFoundException;
import com.skip.api.exception.CustomValidationException;
import com.skip.api.service.CuisineService;
import com.skip.api.service.StoreService;

@RestController
public class CuisineController {

	@Autowired
	private CuisineService cuisineService;
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping("/api/v1/Cousine")
	Iterable<Cuisine> getAllCousines() {
		return cuisineService.findAllCuisines();
	}
	
	@GetMapping("/api/v1/Cousine/search/{searchText}")
	Iterable<Cuisine> getCousinesContainingText(@PathVariable String searchText) throws CustomValidationException {
		return cuisineService.findCuisinesContainingText(searchText);
	}		
	
	@GetMapping("/api/v1/Cousine/{cousineId}/stores")
	Iterable<Store> getStoresByCousineId(@PathVariable long cousineId) throws CuisineNotFoundException {
		return storeService.findStoresByCuisineId(cousineId);
	}
}
