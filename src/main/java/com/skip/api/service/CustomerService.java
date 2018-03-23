package com.skip.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Customer;
import com.skip.api.exception.CustomerAlreadyExistsException;
import com.skip.api.exception.CustomerNotFoundException;
import com.skip.api.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	private CustomerRepository customerRepo;

	public Iterable<Customer> findAllCustomers() {
		return customerRepo.findAll();
	}
	
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
		UserDetails customerAux = customerRepo.findOne(customer.getEmail());
		if (customerAux != null) throw new CustomerAlreadyExistsException(customer.getEmail());		
		customer.setCreation(LocalDateTime.now());
		return customerRepo.save(customer);
	}

	public Customer getCustomerById(long customerId) throws CustomerNotFoundException {
		Customer customer = customerRepo.findOne(customerId);
		if (customer == null) throw new CustomerNotFoundException(customerId);
		return customer;
	}
}
