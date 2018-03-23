package com.skip.api.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Cuisine;
import com.skip.api.domain.Store;
import com.skip.api.exception.CuisineNotFoundException;
import com.skip.api.exception.CustomValidationException;
import com.skip.api.repository.CuisineRepository;
import com.skip.api.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private CuisineRepository cuisineRepo;

	public Store findStoreById(long id) {
		return storeRepo.findOne(id);
	}
	
	public Iterable<Store> findAllStores() {
		return storeRepo.findAll();
	}
	
	public Iterable<Store> findStoresContainingText(String searchText) throws CustomValidationException {
		if (StringUtils.isBlank(searchText)) throw new CustomValidationException("Invalid search text.");
		return storeRepo.findAllContainingText(searchText);
	}

	public Iterable<Store> findStoresByCuisineId(long cuisineId) throws CuisineNotFoundException {
		Cuisine cuisine = cuisineRepo.findOne(cuisineId);
		if (cuisine == null) throw new CuisineNotFoundException(cuisineId);
		return storeRepo.findStoresByCuisine(cuisine);
	}

}
