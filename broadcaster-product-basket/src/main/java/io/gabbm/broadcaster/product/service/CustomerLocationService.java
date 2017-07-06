package io.gabbm.broadcaster.product.service;

import io.gabbm.broadcaster.product.entity.Customer;

public interface CustomerLocationService {
	public Customer getCustomer(Long customerid);
	
	public Long getLocationByCustomerId(Long customerId);
}
