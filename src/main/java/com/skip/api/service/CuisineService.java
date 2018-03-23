package com.skip.api.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.api.exception.CustomValidationException;
import com.skip.api.domain.Cuisine;
import com.skip.api.repository.CuisineRepository;

@Service
public class CuisineService {
	
	@Autowired
	private CuisineRepository cuisineRepo;

	public Iterable<Cuisine> findAllCuisines() {
		return cuisineRepo.findAll();
	}
	
	public Iterable<Cuisine> findCuisinesContainingText(String searchText) throws CustomValidationException {
		if (StringUtils.isBlank(searchText)) throw new CustomValidationException("Invalid search text.");		
		return cuisineRepo.findAllContainingText(searchText);
	}
}
