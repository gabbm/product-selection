package io.gabbm.broadcaster.product.model;

import java.util.ArrayList;
import java.util.List;

public class CheckoutForm {
	
	private Long customerId;

	private List<Long> products = new ArrayList<Long>();
	
	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public List<Long> getProducts() {
		return products;
	}

	public void setProducts(List<Long> products) {
		this.products = products;
	}
}
