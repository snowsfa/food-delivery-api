package com.skip.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skip.api.domain.Customer;
import com.skip.api.exception.CustomerAlreadyExistsException;
import com.skip.api.service.CustomerService;

@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;	
	
	@PostMapping("/api/v1/Customer")	
	public Customer addCustomer(@Valid @RequestBody Customer customer) throws CustomerAlreadyExistsException {
		return customerService.addCustomer(customer);	
	}
	
}
