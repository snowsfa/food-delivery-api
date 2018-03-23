package com.food.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.food.api.model.Customer;
import com.food.api.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.customer = :customer")
	Iterable<Order> findAllByCustomer(@Param("customer") Customer customer);

}
