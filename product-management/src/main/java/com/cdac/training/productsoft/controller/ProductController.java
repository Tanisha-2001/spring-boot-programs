package com.cdac.training.productsoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.training.productsoft.model.Product;
import com.cdac.training.productsoft.service.ProductService;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/products")
    public Product saveProduct(@RequestBody Product p) {
        System.out.println("Received Product: " + p);
        return productService.saveProduct(p);
    }
}
