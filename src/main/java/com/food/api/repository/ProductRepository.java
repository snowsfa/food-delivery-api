package com.food.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.food.api.domain.Product;
import com.food.api.domain.Store;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	@Query("SELECT p FROM Product p WHERE p.name LIKE %:searchText% ")
	Iterable<Product> findAllContainingText(@Param("searchText") String searchText);

	@Query("SELECT p FROM Product p WHERE p.store = :store")
	Iterable<Product> findAllByStore(@Param("store") Store store);
}
