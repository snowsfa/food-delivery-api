package com.food.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.food.api.domain.Cuisine;

@Repository
public interface CuisineRepository extends JpaRepository<Cuisine, Long> {

	@Query("SELECT c FROM Cuisine c WHERE c.name LIKE %:searchText% ")
	Iterable<Cuisine> findAllContainingText(@Param("searchText") String searchText);
	
}
