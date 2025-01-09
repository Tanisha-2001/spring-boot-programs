package com.cdac.training.pms_restapi.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.training.pms_restapi.exception.ResourceNotFoundException;
import com.cdac.training.pms_restapi.model.Product;
import com.cdac.training.pms_restapi.service.ProductService;

/**
 * Author : rajgs
 * Date   : 31 Dec 2024
 * Time   : 5:34:21 pm
 */

/*Spring RestController annotation is used to create RESTful web services using Spring MVC. 
 * Spring RestController takes care of mapping request data to the defined request handler method. 
 * Once response body is generated from the handler method, it converts it to JSON or XML response.
 *  
 * @RestController indicates that this class handles HTTP requests and automatically 
 * serializes the results/response to JSON.
 * 
 * @RequestMapping - maps HTTP request with a path to a controller 
 * */
@RestController
@RequestMapping("/api")
public class ProductController {

	//Field DI
    @Autowired
	private ProductService productService;

	 
	/*
	 * In Spring Boot, a Response Entity is a class that helps in returning a response to a HTTP request. 
	 * It's part of the Spring Framework and is used to simplify the process of returning HTTP responses. 
	 * A ResponseEntity typically includes the HTTP status code, headers, and a body. 
	 * This can be a JSON or XML response, or even a simple string. 
	 * ResponseEntity is a powerful and flexible way to return responses from a Spring Boot application, 
	 * making it easy to manage HTTP communication and handle errors.
	 * 
	 * @RequestBody annotation automatically deserializes the JSON into a Java type
	 * 
	 * @Validated annotation is a tool that helps validate the data being passed to a controller method. 
	 */

	//Open PostMan, make a POST Request - http://localhost:8086/producthive/api/products
	//Select body -> raw -> JSON 
	//Insert JSON product object.

	@PostMapping("/products")
	public ResponseEntity<Product> saveProduct(@Validated @RequestBody Product p) {
		try {
			Product prod= productService.saveProduct(p);
			return ResponseEntity.status(HttpStatus.CREATED).body(prod);
		}
		catch(Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	//Open PostMan/Browser, make a GET Request - http://localhost:8086/producthive/api/products
	@GetMapping("/products")
	public ResponseEntity<List<Product>> displayAllProducts() {

		try {
			List<Product> products=productService.listAll();//Invoke listAll() service method
			return ResponseEntity.ok(products);
		}
		catch(Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}

	/*
	 * The @PathVariable annotation is used to extract the value from the URI. 
	 * It is most suitable for the RESTful web service where the URL contains some value.
	 */
	//Open PostMan/Browser, make a GET Request - http://localhost:8086/producthive/api/products/1004
	//Exception handling is done with Custom Exceptions
	@GetMapping("/products/{pid}")
	public ResponseEntity<Product> getProductById(@PathVariable(value="pid") Long pId) 
			throws ResourceNotFoundException{

		Product p=productService.getSingleProduct(pId).orElseThrow(() ->
		new  ResourceNotFoundException("Product Not Found for this Id : "+pId)); //invokes constructor of ResourceNotFoundException class

		return ResponseEntity.ok(p);
	}


	//Open PostMan, make a PUT Request - http://localhost:8086/producthive/api/products/1004
		//Select body -> raw -> JSON 
		//Update JSON product object with new Values.
		@PutMapping("/products/{pid}")
		public ResponseEntity<Product> updateProduct(@PathVariable(value="pid") Long pId,
				@Validated @RequestBody Product p) throws ResourceNotFoundException {

			Product product=productService.getSingleProduct(pId).
					orElseThrow(() -> new ResourceNotFoundException("Product Not Found for this Id :"+pId));
		
			//Update product with new values
			product.setBrand(p.getBrand());
			product.setMadein(p.getMadein());
			product.setName(p.getName());
			product.setPrice(p.getPrice());

			final Product updatedProduct=productService.saveProduct(product); // invokes service layer method
			return ResponseEntity.ok().body(updatedProduct);
		}
		
		//Open PostMan, make a DELETE Request - http://localhost:8086/producthive/api/products/1004
		@DeleteMapping("/products/{pid}")
		public ResponseEntity<Map<String,Boolean>> deleteProduct(@PathVariable(value="pid") Long pId) 
				throws ResourceNotFoundException {

			productService.getSingleProduct(pId).  // invokes service layer method
			orElseThrow(() -> new ResourceNotFoundException("Product Not Found for this Id :"+pId));

			productService.deleteProduct(pId); // invokes service layer method

			Map<String,Boolean> response=new HashMap<>(); //Map Stores Data in key-value pairs
			response.put("Deleted", Boolean.TRUE);
			
			return ResponseEntity.ok(response);
		}

}
