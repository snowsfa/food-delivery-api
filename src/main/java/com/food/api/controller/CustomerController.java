package com.food.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.food.api.domain.Customer;
import com.food.api.exception.CustomerAlreadyExistsException;
import com.food.api.service.CustomerService;

@RestController("/api/v1/Customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;	
	
	/**
	 * Returns: 
	 * - HttpStatus (201) and the created customer object if the operation is successful. 
	 * - HttpStatus (400) if customer's data are invalid.
	 * - HttpStatus (409) if customer already exists. 
	 * @param customer Customer object
	 * @return Created customer object  
	 * @throws CustomerAlreadyExistsException
	 */
	@PostMapping()
	@ResponseStatus(HttpStatus.CREATED)
	public Customer addCustomer(@Valid @RequestBody Customer customer) throws CustomerAlreadyExistsException {
		return customerService.addCustomer(customer);	
	}
	
}
