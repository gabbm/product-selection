package io.gabbm.broadcaster.product.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.gabbm.broadcaster.product.entity.Product;
import io.gabbm.broadcaster.product.service.CatalogueService;
import io.gabbm.broadcaster.product.service.CustomerLocationService;

@RestController
@RequestMapping("/api")
public class ApiController {

	@Autowired
	private CustomerLocationService customerLocationService;
	
	@Autowired
	private CatalogueService catalogueService;
	
	@RequestMapping("/products/user/{customerId}")
	public Set<Product> fetchProductsByCustomerLocation(@PathVariable(name="customerId", required=true) Long customerId){
		Set<Product> products = new HashSet<Product>();
		
		Long locationId = customerLocationService.getLocationByCustomerId(customerId);
		
		if(locationId != null){
			products = catalogueService.getProductsByLocation(locationId);
		}
		
		return products;
	}
}
