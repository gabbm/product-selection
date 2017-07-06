package io.gabbm.broadcaster.product.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.gabbm.broadcaster.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	Set<Product> findByLocationIsNull();
	Set<Product> findByTypeAndLocationIsNull(String type);
	
	@Query("SELECT p FROM Product p JOIN FETCH p.location l WHERE l.id = ?1")
	Set<Product> findByLocation(Long locationId);
	
	@Query("SELECT p FROM Product p JOIN FETCH p.location l WHERE p.type = '?1' AND l.id = ?2")
	Set<Product> findByLocationAndType(Long locationId, String type);
}
