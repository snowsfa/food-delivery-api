package com.food.api.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.food.api.exception.CustomerAlreadyExistsException;
import com.food.api.exception.CustomerNotFoundException;
import com.food.api.model.Customer;
import com.food.api.repository.CustomerRepository;

@Service("userDetailsService")
public class CustomerService implements UserDetailsService {
	
	@Autowired
	private CustomerRepository customerRepo;

	public Customer findCustomerById(Long id) throws CustomerNotFoundException {
		return customerRepo
				.findById(id)
				.orElseThrow(() -> new CustomerNotFoundException(id));
	}
	
	public Customer findCustomerByEmail(String email) throws CustomerNotFoundException {
		return customerRepo
				.findByEmail(email)
				.orElseThrow(() -> new CustomerNotFoundException(email));
	}	
	
	public Iterable<Customer> findAllCustomers() {
		return customerRepo.findAll();
	}
	
	public Customer addCustomer(Customer customer) throws CustomerAlreadyExistsException {
		customerRepo
				.findByEmail(customer.getEmail())
				.orElseThrow(() -> new CustomerAlreadyExistsException(customer.getEmail()));

		customer.setCreation(LocalDateTime.now());
		return customerRepo.save(customer);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return customerRepo
				.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("No user found with username: " + username));
	}

}
