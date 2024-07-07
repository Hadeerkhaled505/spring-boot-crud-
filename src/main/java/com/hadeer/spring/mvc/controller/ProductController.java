package com.hadeer.spring.mvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hadeer.spring.mvc.entity.Product;
import com.hadeer.spring.mvc.service.ProductSevice;

@RestController
public class ProductController {
	@Autowired
private ProductSevice service;
	@PostMapping("/addproduct")
	public Product addProduct(@RequestBody Product product) {
		return service.saveproduct(product);
		
		
	}
	@PostMapping("/addproducts")
	public List<Product> addProduct(@RequestBody List<Product> product) {
		
		return service.getProduct();
			
	}
//	 public String deleteProductById(int id) {
//		 repositroy.deleteById(id);
//		return "product removed ||"+id;	
//		}
	
//public Product deleteProduct(@Request Product product) {
//		
//		return service.deleteProduct(product);
//			
//	}

	// get product by id
// public Product getProductById(int id){
//	return repositroy.findById(id).orElse(null);
//	 
// }	
	@GetMapping("/product/{id}")
	public String findProductById(@PathVariable int id) {
		return service.deleteProductById(id);	
		
	}
	@GetMapping("/product/{name}")
	public Product getProductByName(@PathVariable String name) {
		return service.getProductByName(name);		
	}
	@GetMapping("/products")
	public List	<Product> findAllProduct() {
		return service.getProduct();	
		
	}
	@PutMapping("/updateproduct")
	public Product updateProduct(@RequestBody Product product) throws Exception {
		return service.updateProduct(product);	
	}

	@DeleteMapping("/deleteproduct/{id}")
	public String deleteProduct(@PathVariable  int id) {
	
	return service.deleteProductById(id);
		
}
	
	
}
