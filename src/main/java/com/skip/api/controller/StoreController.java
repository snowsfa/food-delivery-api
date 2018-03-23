package com.skip.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skip.api.domain.Product;
import com.skip.api.domain.Store;
import com.skip.api.exception.CustomValidationException;
import com.skip.api.exception.StoreNotFoundException;
import com.skip.api.service.ProductService;
import com.skip.api.service.StoreService;

@RestController
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@Autowired 
	private ProductService productService;	
	
	@GetMapping("/api/v1/Store")
	public Iterable<Store> getAllStores() {
		return storeService.findAllStores();
	}	
	
	@GetMapping("/api/v1/Store/search/{searchText}")
	Iterable<Store> getStoresContainingText(@PathVariable String searchText) throws CustomValidationException {
		return storeService.findStoresContainingText(searchText);
	}		
			
	@GetMapping("/api/v1/Store/{storeId}")
	public Store getStoreById(@PathVariable long storeId) {
		return storeService.findStoreById(storeId);
	}
		
	@GetMapping("/api/v1/Store/{storeId}/products")	
	public Iterable<Product> getProductsByStoreId(@PathVariable long storeId) throws StoreNotFoundException {
		return productService.findProductsByStoreId(storeId);	
	}
	
}
