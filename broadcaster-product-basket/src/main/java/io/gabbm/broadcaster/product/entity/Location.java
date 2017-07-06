package io.gabbm.broadcaster.product.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
public class Location {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@OneToMany(fetch = FetchType.LAZY, 
			mappedBy = "location",
			orphanRemoval = true)
	@Cascade({CascadeType.PERSIST})
	private Set<Customer> customers = new HashSet<Customer>();
	
	@OneToMany(fetch = FetchType.LAZY, 
			mappedBy = "location",
			orphanRemoval = true)
	@Cascade({CascadeType.PERSIST})
	private Set<Product> products = new HashSet<Product>();
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Set<Customer> getCustomers(){
		return customers;
	}
	public Set<Product> getProducts(){
		return products;
	}
	
}
