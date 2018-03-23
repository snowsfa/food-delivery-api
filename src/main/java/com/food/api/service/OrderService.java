package com.food.api.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.food.api.domain.Customer;
import com.food.api.domain.Order;
import com.food.api.domain.OrderItem;
import com.food.api.enums.OrderStatusEnum;
import com.food.api.exception.CustomerNotFoundException;
import com.food.api.exception.OrderNotFoundException;
import com.food.api.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepo;
	
	@Autowired
	private CustomerService customerService;

	public Order findOrderById(Long id) throws OrderNotFoundException {
		return orderRepo
				.findById(id)
				.orElseThrow(() -> new OrderNotFoundException(id));
	}
	
	public Iterable<Order> findAllOrdersByCustomerId(Long customerId) throws CustomerNotFoundException {
		Customer customer = customerService.findCustomerById(customerId);
		return orderRepo.findAllByCustomer(customer);
	}
	
	public Iterable<Order> findAllOrdersByCustomer(Customer customer) {
		return orderRepo.findAllByCustomer(customer);
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
