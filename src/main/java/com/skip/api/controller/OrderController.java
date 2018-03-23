package com.skip.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.skip.api.domain.Customer;
import com.skip.api.domain.Order;
import com.skip.api.repository.CustomerRepository;
import com.skip.api.service.OrderService;

@RestController
public class OrderController {

	@Autowired
	private OrderService orderService;	
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@GetMapping("/api/v1/Order/{orderId}")
	public Order getOrderById(@PathVariable long orderId) {
		return orderService.findOrderById(orderId);
	}
		
	@PostMapping("/api/v1/Order")	
	public Order addOrder(@Valid @RequestBody Order order) {
		return orderService.addOrder(order);	
	}
	
	@GetMapping("/api/v1/Order/customer")
	public Iterable<Order> getOrdersByAuthenticatedCustomer() {
		// get the email of current user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Customer customer = (Customer) auth.getPrincipal();
		customerRepo.findOne(customer.getEmail());
		
		// search
		return orderService.findOrdersByCustomer(customer);
	}
	
}
