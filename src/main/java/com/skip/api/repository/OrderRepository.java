package com.skip.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skip.api.domain.Customer;
import com.skip.api.domain.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

	@Query("SELECT o FROM Order o WHERE o.customer = :customer")
	Iterable<Order> findByCustomer(@Param("customer") Customer customer);

}
