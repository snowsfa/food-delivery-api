package com.food.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.food.api.exception.CuisineNotFoundException;
import com.food.api.model.Cuisine;
import com.food.api.model.Store;
import com.food.api.service.CuisineService;
import com.food.api.service.StoreService;

@RestController("/api/v1/Cousine")
public class CuisineController {

	@Autowired
	private CuisineService cuisineService;
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping()
	Iterable<Cuisine> getAllCousines() {
		return cuisineService.findAllCuisines();
	}
	
	@GetMapping("/search/{searchText}")
	Iterable<Cuisine> getCousinesContainingText(@PathVariable String searchText) {
		return cuisineService.findAllCuisinesContainingText(searchText);
	}		
	
	@GetMapping("/{cousineId}/stores")
	Iterable<Store> getStoresByCousineId(@PathVariable long cousineId) throws CuisineNotFoundException {
		return storeService.findAllStoresByCuisineId(cousineId);
	}
}
