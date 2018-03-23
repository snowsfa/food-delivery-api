package com.food.api.service;

import java.security.InvalidParameterException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.api.exception.CuisineNotFoundException;
import com.food.api.model.Cuisine;
import com.food.api.repository.CuisineRepository;

@Service
public class CuisineService {
	
	@Autowired
	private CuisineRepository cuisineRepo;

	public Cuisine findCuisineById(Long id) throws CuisineNotFoundException {
		return cuisineRepo
				.findById(id)
				.orElseThrow(() -> new CuisineNotFoundException(id));
	}
	
	public Iterable<Cuisine> findAllCuisines() {
		return cuisineRepo.findAll();
	}
	
	public Iterable<Cuisine> findAllCuisinesContainingText(String searchText) {
		if (StringUtils.isBlank(searchText)) throw new InvalidParameterException("Invalid search text.");
		return cuisineRepo.findAllContainingText(searchText);
	}
}
