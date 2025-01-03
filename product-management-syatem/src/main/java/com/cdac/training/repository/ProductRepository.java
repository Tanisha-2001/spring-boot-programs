package com.cdac.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cdac.training.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

	
	
}
