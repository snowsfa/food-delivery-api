package com.food.api.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.food.api.exception.CustomerNotFoundException;
import com.food.api.exception.OrderNotFoundException;
import com.food.api.model.Customer;
import com.food.api.model.Order;
import com.food.api.service.CustomerService;
import com.food.api.service.OrderService;

@RestController
@RequestMapping("/api/v1/Order")
public class OrderController {

	@Autowired
	private OrderService orderService;	
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/{orderId}")
	public Order getOrderById(@PathVariable long orderId) throws OrderNotFoundException {
		return orderService.findOrderById(orderId);
	}
		
	@PostMapping()
	public Order addOrder(@Valid @RequestBody Order order) {
		return orderService.addOrder(order);	
	}
	
	@GetMapping("/api/v1/Order/customer")
	public Iterable<Order> getOrdersByAuthenticatedCustomer() throws CustomerNotFoundException {
		
		// get the email of current user
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Customer customer = (Customer) auth.getPrincipal();
		customerService.findCustomerByEmail(customer.getEmail());
		
		// search
		return orderService.findAllOrdersByCustomer(customer);
	}
	
}
