package io.gabbm.broadcaster.product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import io.gabbm.broadcaster.product.entity.Customer;
import io.gabbm.broadcaster.product.entity.Product;
import io.gabbm.broadcaster.product.model.Basket;
import io.gabbm.broadcaster.product.model.CheckoutForm;
import io.gabbm.broadcaster.product.service.CatalogueService;
import io.gabbm.broadcaster.product.service.CustomerLocationService;

@Controller
public class ProductController {
	
	@Autowired
	CatalogueService catalogueService;
	
	@Autowired
	CustomerLocationService customerLocationService;
	
	@RequestMapping("/")
	public String home(Model model, 
			@RequestParam(value="customerId", required=false) Long customerId){
		
		return "redirect:products" + 
				(customerId != null ? ("?customerId=" + customerId) : "");
	}
	
	@RequestMapping("/products")
	public String products(Model model, 
			@RequestParam(value="customerId", required=false) Long customerId){
		
		model.addAttribute(new CheckoutForm());
		
		return "products";
	}
	
	@RequestMapping("/checkout")
	public String checkout(Model model,
			@ModelAttribute("checkoutForm") CheckoutForm checkoutForm){
	
		Customer customer = checkoutForm.getCustomerId() != null ?
				customerLocationService.getCustomer(checkoutForm.getCustomerId()) : null;
		
		if(customer != null && !checkoutForm.getProducts().isEmpty()){
			Basket basket = new Basket();
			Product product;
			
			basket.setOrderId(Math.round(Math.random()*100));
			basket.setCustomer(customer);
			
			for(Long productId : checkoutForm.getProducts()){
				product = catalogueService.getProductById(productId);
				
				if(product != null){
					basket.getProducts().add(product);
				}
			}
			
			model.addAttribute(basket);
		
			return "checkout";
		}else{
			return "redirect:products";
		}
		
	}
}
