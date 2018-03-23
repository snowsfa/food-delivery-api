package com.skip.api.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skip.api.domain.Customer;
import com.skip.api.domain.Order;
import com.skip.api.domain.OrderItem;
import com.skip.api.enums.OrderStatusEnum;
import com.skip.api.exception.CustomerNotFoundException;
import com.skip.api.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CustomerService customerService;

	public Order findOrderById(long id) {
		return orderRepo.findOne(id);
	}
	
	public Iterable<Order> findOrdersByCustomerId(long CustomerId) throws CustomerNotFoundException {
		Customer customer = customerService.getCustomerById(CustomerId);
		return orderRepo.findByCustomer(customer);
	}
	
	public Iterable<Order> findOrdersByCustomer(Customer customer) {
		return orderRepo.findByCustomer(customer);
	}	

	public Order addOrder(Order order) {
		
		// calculate total
		BigDecimal total = BigDecimal.ZERO; 
		for (OrderItem orderItem : order.getOrderItems()) {			
			BigDecimal itemsPrice = orderItem.getPrice().multiply(BigDecimal.valueOf(orderItem.getQuantity()));  
			total = total.add(itemsPrice);
		}
		
		order.setDate(LocalDateTime.now());
		order.setLastUpdate(LocalDateTime.now());
		order.setStatus(OrderStatusEnum.ORDERED);
		order.setTotal(total);	
		
		return orderRepo.save(order);		
	}

}
