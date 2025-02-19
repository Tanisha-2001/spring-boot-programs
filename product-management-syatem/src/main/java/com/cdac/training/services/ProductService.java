package com.cdac.training.services;

import org.springframework.stereotype.Service;

import com.cdac.training.model.Product;
import com.cdac.training.repository.ProductRepository;

@Service
public class ProductService {

	private final ProductRepository productRepository ;

	public ProductService(ProductRepository productRepository) {
		this.productRepository=productRepository;
	}
	
	
	public Product save(Product p)
	{
		return productRepository.save(p);
	}
}
