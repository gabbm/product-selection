package io.gabbm.broadcaster.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.gabbm.broadcaster.product.entity.Customer;
import io.gabbm.broadcaster.product.repository.CustomerRepository;
import io.gabbm.broadcaster.product.service.CustomerLocationService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CustomerLocationServiceImpl implements CustomerLocationService{

	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public Customer getCustomer(Long customerId){
		return customerRepository.findByIdWithLocation(customerId);
	}
	
	@Override
	public Long getLocationByCustomerId(Long customerId) {
		Customer customer = getCustomer(customerId);
		
		return (customer != null && customer.getLocation() != null) ? customer.getLocation().getId() : null;
	}

}
