package io.gabbm.broadcaster.product.service;

import java.util.Set;

import io.gabbm.broadcaster.product.entity.Product;

public interface CatalogueService {
	
	public Product getProductById(Long productId);
	public Set<Product> getProductsByLocation(Long locationId);
	public Set<Product> getProductsByLocationAndType(Long locationId, String type);
}
