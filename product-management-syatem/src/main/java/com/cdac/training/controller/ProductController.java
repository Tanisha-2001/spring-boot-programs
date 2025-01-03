package com.cdac.training.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.training.ProductService;
import com.cdac.training.model.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api")
public class ProductController {
@Autowired
private ProductService producService;




@PostMapping("/products")
public Product AddProduct(@RequestBody Product p)
{
	return producService.save(p);
	}


	
	
	
	
	
	
	
	
}
