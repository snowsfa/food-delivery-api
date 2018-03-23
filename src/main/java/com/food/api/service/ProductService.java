package com.food.api.service;

import java.security.InvalidParameterException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.api.domain.Product;
import com.food.api.domain.Store;
import com.food.api.exception.ProductNotFoundException;
import com.food.api.exception.StoreNotFoundException;
import com.food.api.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private StoreService storeService;

	public Product findProductById(Long id) throws ProductNotFoundException {
		return productRepo
				.findById(id)
				.orElseThrow(() -> new ProductNotFoundException(id));
	}
	
	public Iterable<Product> findAllProducts() {
		return productRepo.findAll();
	}
	
	public Iterable<Product> findAllProductsContainingText(String searchText) {
		if (StringUtils.isBlank(searchText)) throw new InvalidParameterException("Invalid search text.");
		return productRepo.findAllContainingText(searchText);
	}

	public Iterable<Product> findAllProductsByStoreId(Long storeId) throws StoreNotFoundException {
		Store store = storeService.findStoreById(storeId);
		return productRepo.findAllByStore(store);		
	}
}
