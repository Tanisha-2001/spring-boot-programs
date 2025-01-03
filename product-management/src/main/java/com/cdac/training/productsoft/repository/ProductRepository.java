package com.cdac.training.productsoft.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cdac.training.productsoft.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
