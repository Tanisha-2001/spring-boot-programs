package com.cdac.training.pmsrestapi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

@Entity
public class Product {
    @Id
   
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "product_seq")
    @SequenceGenerator(name = "product_seq", initialValue = 1000, allocationSize = 1)
    private Long id;


    public Product() {
	}

	public Product( String name, String description, Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	@Column(nullable = false)
    private String name;

    private String description;

    @Column(nullable = false)
    private Double price;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}

