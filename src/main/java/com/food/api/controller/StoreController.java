package com.food.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.api.exception.StoreNotFoundException;
import com.food.api.model.Product;
import com.food.api.model.Store;
import com.food.api.service.ProductService;
import com.food.api.service.StoreService;

@RestController
@RequestMapping("/api/v1/Store")
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@Autowired 
	private ProductService productService;	
	
	@GetMapping()
	public Iterable<Store> getAllStores() {
		return storeService.findAllStores();
	}	
	
	@GetMapping("/search/{searchText}")
	Iterable<Store> getStoresContainingText(@PathVariable String searchText) {
		return storeService.findAllStoresContainingText(searchText);
	}		
			
	@GetMapping("/{storeId}")
	public Store getStoreById(@PathVariable long storeId) throws StoreNotFoundException {
		return storeService.findStoreById(storeId);
	}
		
	@GetMapping("/{storeId}/products")	
	public Iterable<Product> getProductsByStoreId(@PathVariable long storeId) throws StoreNotFoundException {
		return productService.findAllProductsByStoreId(storeId);	
	}
	
}
