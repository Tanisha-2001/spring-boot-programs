package com.cdac.training.pmsrestapi.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.training.pmsrestapi.model.Product;
import com.cdac.training.pmsrestapi.service.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/products")
public class ProductController {
	@Autowired
	private ProductService productService;

	@GetMapping("")
	public List<Product> getAllProducts() {
		return productService.getAllPrducts();
	}
	@GetMapping("/{id}")
	public Optional<Product> getProductById(@PathVariable long id) {
		return productService.getProductById(id);
	}
	

	@PostMapping("/")
	public Product addProduct(@RequestBody Product product) {
		return productService.addProduct(product);
	}
	@PutMapping("/{id}")
	public Product updateProduct(@PathVariable long id, @RequestBody Product product) {
		return productService.updateProduct(id,product);
	}
	
	@DeleteMapping("/{id}")
	public void deleteProduct(@PathVariable long id)
	{
		productService.deleteProduct(id);
	}


}
