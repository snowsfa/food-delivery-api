package com.skip.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.skip.api.domain.Cuisine;
import com.skip.api.domain.Store;

@Repository
public interface StoreRepository extends JpaRepository<Store, Long> {

	@Query("SELECT s FROM Store s WHERE s.name LIKE %:searchText% ")
	Iterable<Store> findAllContainingText(@Param("searchText") String searchText);

	@Query("SELECT s FROM Store s INNER JOIN s.cuisines c WHERE c = :cuisine")
	Iterable<Store> findStoresByCuisine(@Param("cuisine") Cuisine cuisine);
}
