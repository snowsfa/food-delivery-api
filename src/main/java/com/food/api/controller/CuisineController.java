package com.food.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.api.exception.CuisineNotFoundException;
import com.food.api.model.Cuisine;
import com.food.api.model.Store;
import com.food.api.service.CuisineService;
import com.food.api.service.StoreService;

@RestController
@RequestMapping("/api/v1/Cuisine")
public class CuisineController {

	@Autowired
	private CuisineService cuisineService;
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping()
	Iterable<Cuisine> getAllCuisines() {
		return cuisineService.findAllCuisines();
	}
	
	@GetMapping("/search/{searchText}")
	Iterable<Cuisine> getCuisinesContainingText(@PathVariable String searchText) {
		return cuisineService.findAllCuisinesContainingText(searchText);
	}		
	
	@GetMapping("/{cuisineId}/stores")
	Iterable<Store> getStoresByCuisineId(@PathVariable long cuisineId) throws CuisineNotFoundException {
		return storeService.findAllStoresByCuisineId(cuisineId);
	}
}
