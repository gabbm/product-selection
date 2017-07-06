package io.gabbm.broadcaster.product;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;

import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import io.gabbm.broadcaster.product.controller.ApiController;
import io.gabbm.broadcaster.product.entity.Customer;
import io.gabbm.broadcaster.product.entity.Product;
import io.gabbm.broadcaster.product.service.CatalogueService;
import io.gabbm.broadcaster.product.service.CustomerLocationService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
	
	@Autowired
	CustomerLocationService customerLocationService;
	
	@Autowired
	CatalogueService catalogueService;
	
	@Autowired
	ApiController apiController;
	
	
	@Test
	public void getLocationByCustomer(){
		Assert.assertEquals(1L, customerLocationService.getLocationByCustomerId(1L).longValue());
		Assert.assertNotEquals(1L, customerLocationService.getLocationByCustomerId(2L).longValue());
		Assert.assertNull(customerLocationService.getLocationByCustomerId(5L));
	}
	
	@Test
	public void getProductsByLocation(){
		Set<Product> products = catalogueService.getProductsByLocation(1L);
		
		Assert.assertNotNull(products);
		
		for(Product product : products){
			Long location = product.getLocation() != null ? product.getLocation().getId() : null;
			
			Assert.assertThat(location, anyOf(is(1L), is(nullValue())));
			Assert.assertThat(location, is(not(2L)));
			Assert.assertThat(product.getId(), anyOf(is(1L), is(2L), is(4L), is(5L)));
			Assert.assertThat(product.getId(), is(not(3L)));
		}		
	}

	public void getProductsByCustomer(){
		Customer customer = customerLocationService.getCustomer(2L);
		
		Assert.assertEquals(2L, customer.getId().longValue());
		Assert.assertEquals(2L, customer.getLocation().getId().longValue());
		
		Set<Product> products = catalogueService.getProductsByLocation(customer.getLocation().getId());
		
		Assert.assertNotNull(products);
		
		for(Product product : products){
			Long location = product.getLocation() != null ? product.getLocation().getId() : null;
			
			Assert.assertThat(location, anyOf(is(2L), is(nullValue())));
			Assert.assertThat(location, is(not(1L)));
			Assert.assertThat(product.getId(), anyOf(is(3L), is(4L), is(5L)));
			Assert.assertThat(product.getId(), anyOf(is(not(1L)), not(2L)));
		}	
	}
}
