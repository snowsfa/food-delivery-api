package com.food.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.food.api.exception.ProductNotFoundException;
import com.food.api.model.Product;
import com.food.api.service.ProductService;

@RestController("/api/v1/Product")
public class ProductController {

	@Autowired 
	private ProductService productService;	
	
	@GetMapping()
	public Iterable<Product> getAllProducts() {
		return productService.findAllProducts();
	}	
	
	@GetMapping("/search/{searchText}")
	Iterable<Product> getProductsContainingText(@PathVariable String searchText) {
		return productService.findAllProductsContainingText(searchText);
	}		
			
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable long productId) throws ProductNotFoundException {
		return productService.findProductById(productId);
	}
	
}
