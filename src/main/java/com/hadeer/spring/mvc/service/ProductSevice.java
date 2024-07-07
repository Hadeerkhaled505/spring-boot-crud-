package com.hadeer.spring.mvc.service;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadeer.spring.mvc.entity.Product;
import com.hadeer.spring.mvc.repository.ProductRepository;

@Service
public class ProductSevice {
	@Autowired
private ProductRepository repositroy;
// insert product item
public	Product saveproduct(Product product) {	
		return repositroy.save(product);	
	}
	
// insert product items
public	List <Product> saveproducts(List<Product> products) {	
	return (List<Product>) repositroy.saveAll( products);	
}

	// get product by id
 public Product getProductById(int id){
	return repositroy.findById(id).orElse(null);
	 
 }	
 // get list of product
 public List<Product> getProduct(){
	return repositroy.findAll();	 
 } 

 public Product getProductByName(String name) {
	return repositroy.findByName(name);
	
}
// public void deleteProductById(int id) {
//	 repositroy.deleteById(id);
//		
//	}
 public String deleteProductById(int id) {
	 repositroy.deleteById(id);
	return "product removed ||"+id;	
	}
// public  Product updateProduct(Product product) {
// Optional<Product> existingproduct= repositroy.findById(product.getId());
//
//	return product;	 
//	 
// }
 public Product updateProduct(Product product) throws Exception {
	    Optional<Product> existingProduct = repositroy.findById(product.getId());
	    
	    if (existingProduct.isPresent()) {
	        Product productToUpdate = existingProduct.get();
	        // You can now access and update the fields of productToUpdate as needed
	        productToUpdate.setName(product.getName());
	        productToUpdate.setPrice(product.getPrice());
	        productToUpdate.setQuantity(product.getQuantity());
	        productToUpdate.setId(product.getId());
	        // Add any other fields that need to be updated

	        repositroy.save(productToUpdate);
	        return productToUpdate;
	    } else {
	        // Handle the case where the product does not exist
	        throw new Exception("Product not found with id: " + product.getId());
	    }
	}

}
