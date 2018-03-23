package com.skip.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.skip.api.domain.Product;
import com.skip.api.exception.CustomValidationException;
import com.skip.api.exception.ProductNotFoundException;
import com.skip.api.service.ProductService;

@RestController
public class ProductController {

	@Autowired 
	private ProductService productService;	
	
	@GetMapping("/api/v1/Product")
	public Iterable<Product> getAllProducts() {
		return productService.findAllProducts();
	}	
	
	@GetMapping("/api/v1/Product/search/{searchText}")
	Iterable<Product> getProductsContainingText(@PathVariable String searchText) throws CustomValidationException {
		return productService.findProductsContainingText(searchText);
	}		
			
	@GetMapping("/api/v1/Product/{productId}")
	public Product getProductById(@PathVariable long productId) throws ProductNotFoundException {
		return productService.getProductById(productId);
	}
	
}
