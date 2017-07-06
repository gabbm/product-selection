package io.gabbm.broadcaster.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.gabbm.broadcaster.product.entity.Customer;

public interface LocationRepository extends JpaRepository<Customer, Long>{

}
