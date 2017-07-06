package io.gabbm.broadcaster.product;

import static org.hamcrest.core.IsNot.not;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class ApiTest {

	@Autowired
    private TestRestTemplate testRestTemplate;
	
	@Test
	public void getProductsByCustomerAjax(){
		ResponseEntity<String> responseEntity = testRestTemplate.getForEntity("/api/products/user/1", String.class);
		
		Assert.assertThat(responseEntity.getStatusCodeValue(), is(200));
		Assert.assertThat(responseEntity.getBody(), containsString("Arsenal TV"));
		Assert.assertThat(responseEntity.getBody(), containsString("Sky News"));
		Assert.assertThat(responseEntity.getBody(), not(containsString("Liverpool TV")));

	}
}
