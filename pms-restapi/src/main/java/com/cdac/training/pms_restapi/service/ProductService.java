package com.cdac.training.pms_restapi.service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.training.pms_restapi.model.Product;
import com.cdac.training.pms_restapi.repository.ProductRepository;

/**
 * Author : rajgs
 * Date   : 31 Dec 2024
 * Time   : 5:30:06 pm
 * Business Logic of WEb Service is implemented in Service Layer
*/

/*
 * @Service annotation is a stereotype annotation that marks a class as a service layer component. 
 * It's one of the core annotations used to structure your application and enable dependency injection.
 * 
 * The @Service annotation tells Spring that the annotated class contains business logic. 
 * It's typically where you'll implement the core functionality of your application, 
 * such as calculations, data retrieval, or external API interactions.
 */

@Service
public class ProductService {
	@Autowired
	private final ProductRepository productRepository;
	
	// Constructor DI
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public Product saveProduct(Product p) {
		return productRepository.save(p); //invokes pred-defined method save() of JPA Repo
	}

	public List<Product> listAll(){
		return productRepository.findAll();//invokes pred-defined method findAll() of JPA Repo
	}
	
	// Optional return type is to handle Null Pointer Exception
	   public Optional<Product> getSingleProduct(long pid) {
		   return productRepository.findById(pid);       //Invokes pre-defined method findById() of JPA repository
	   }
	   
	   public void deleteProduct(long pid) {
		   productRepository.deleteById(pid); //Invokes pre-defined method deleteById() of JPA repository
	   }

}
