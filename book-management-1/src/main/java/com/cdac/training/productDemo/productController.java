package com.cdac.training.productDemo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/books")
public class productController {

	private List<Product> productList = new ArrayList<>();

	@GetMapping("")
	public List<Product> getAllproduct() {
		return productList;
	}

	@PostMapping("")
	public Product addProduct(@RequestBody Product product) {
		product.setId((long) productList.size() + 1);
		productList.add(product);
		return product;
	}

	@PutMapping("/{id}")
	public String updateProduct(@PathVariable long id, @RequestBody Product product) {
		Product prdct = findproductbyId(id);
		if (prdct == null) {
			return "not available";
		}
		prdct.setName(product.getName());
		prdct.setDescription(product.getDescription());
		prdct.setPrice(product.getPrice());
		return "updated!";
	}

	@DeleteMapping("/{id}")
	private String deletproduct(@PathVariable long id) {
		Product prdct = findproductbyId(id);
		if (prdct == null) {
			return "not available";
		}
		productList.remove(prdct);
		return "Deletion Completed!";
	}

	private Product findproductbyId(long id) {
		for (Product product : productList) {
			if (product.getId().equals(id))
				return product;

		}
		return null;
	}
}
