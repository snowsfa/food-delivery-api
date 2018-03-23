package com.food.api.service;

import java.security.InvalidParameterException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.food.api.repository.CustomerRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Override
	public UserDetails loadUserByUsername(String email) {
		return customerRepo
				.findByEmail(email)
				.orElseThrow(() -> new InvalidParameterException());
	}

}
