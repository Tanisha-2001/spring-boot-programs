package com.cdac.training.pmsrestapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.training.pmsrestapi.model.Product;

public interface productRepository extends JpaRepository<Product, Long> {

}
