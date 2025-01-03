package com.cdac.training.productsoft.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdac.training.productsoft.model.Product;
import com.cdac.training.productsoft.repository.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product p) {
        return productRepository.save(p);
    }
}
