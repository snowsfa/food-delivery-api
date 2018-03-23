package com.food.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.api.exception.CuisineNotFoundException;
import com.food.api.exception.StoreNotFoundException;
import com.food.api.model.Cuisine;
import com.food.api.model.Store;
import com.food.api.repository.StoreRepository;

@Service
public class StoreService {
	
	@Autowired
	private StoreRepository storeRepo;
	
	@Autowired
	private CuisineService cuisineService;

	public Store findStoreById(Long id) throws StoreNotFoundException {
		return storeRepo
				.findById(id)
				.orElseThrow(() -> new StoreNotFoundException(id));
	}
	
	public Iterable<Store> findAllStores() {
		return storeRepo.findAll();
	}
	
	public Iterable<Store> findAllStoresContainingText(String searchText) {
		return storeRepo.findAllContainingText(searchText);
	}

	public Iterable<Store> findAllStoresByCuisineId(long cuisineId) throws CuisineNotFoundException {
		Cuisine cuisine = cuisineService.findCuisineById(cuisineId);
		return storeRepo.findStoresByCuisine(cuisine);
	}

}
