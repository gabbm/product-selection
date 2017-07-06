package io.gabbm.broadcaster.product.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import io.gabbm.broadcaster.product.entity.Product;
import io.gabbm.broadcaster.product.repository.ProductRepository;
import io.gabbm.broadcaster.product.service.CatalogueService;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CatalogueServiceImpl implements CatalogueService{

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Set<Product> getProductsByLocation(Long locationId) {
		Set<Product> userProducts = productRepository.findByLocation(locationId);
		Set<Product> emptyProducts = productRepository.findByLocationIsNull();

		if(userProducts != null){
			userProducts.addAll(emptyProducts);
		}else{
			userProducts = emptyProducts;
		}
		
		return userProducts;
	}

	@Override
	public Set<Product> getProductsByLocationAndType(Long locationId, String type) {
		if(type != null){
			Set<Product> userProducts = productRepository.findByLocationAndType(locationId, type);
			Set<Product> emptyProducts = productRepository.findByLocationIsNull();
			
			if(userProducts != null){
				userProducts.addAll(emptyProducts);
			}else{
				userProducts = emptyProducts;
			}
			
			return userProducts;
		}else{
			return getProductsByLocation(locationId);
		}
	}

	@Override
	public Product getProductById(Long productId) {
		return productRepository.findOne(productId);
	}
	
}
