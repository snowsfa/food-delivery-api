package com.skip.api.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Product;
import com.skip.api.domain.Store;
import com.skip.api.exception.CustomValidationException;
import com.skip.api.exception.ProductNotFoundException;
import com.skip.api.exception.StoreNotFoundException;
import com.skip.api.repository.ProductRepository;
import com.skip.api.repository.StoreRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepo;
	
	@Autowired
	private StoreRepository storeRepo;

	public Product getProductById(long id) throws ProductNotFoundException {
		Product product = productRepo.findOne(id);
		if (product == null) throw new ProductNotFoundException(id);
		return product;
	}
	
	public Iterable<Product> findAllProducts() {
		return productRepo.findAll();
	}
	
	public Iterable<Product> findProductsContainingText(String searchText) throws CustomValidationException {
		if (StringUtils.isBlank(searchText)) throw new CustomValidationException("Invalid search text.");
		return productRepo.findAllContainingText(searchText);
	}

	public Iterable<Product> findProductsByStoreId(long storeId) throws StoreNotFoundException {
		Store store = storeRepo.findOne(storeId);
		if (store == null) throw new StoreNotFoundException(storeId);
		return productRepo.findAllByStore(store);		
	}
}
