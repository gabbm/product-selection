package io.gabbm.broadcaster.product.model;

import java.util.HashSet;
import java.util.Set;

import io.gabbm.broadcaster.product.entity.Customer;
import io.gabbm.broadcaster.product.entity.Product;


public class Basket {
	private Long orderId;
	private Customer customer;
	private Set<Product> products = new HashSet<Product>();

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

}
