package io.gabbm.broadcaster.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import io.gabbm.broadcaster.product.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{
	
	@Query("SELECT c FROM Customer c JOIN FETCH c.location l WHERE c.id = ?1")
	Customer findByIdWithLocation(Long id);
}
