package com.cdac.training.pms_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cdac.training.pms_restapi.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	/* Long is data type of @Id field of Product Class
	 * 
	 * This interface has save(),findAll(),findById(),deleteById(),count()
       etc.. inbuilt methods of jpa repository for various database operations.
       
       This interface will be implemented by class automatically
	 */
}


