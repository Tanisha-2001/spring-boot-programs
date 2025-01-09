package com.cdac.training.pmsrestapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cdac.training.pmsrestapi.model.Product;
import com.cdac.training.pmsrestapi.repository.productRepository;

@Service
public class ProductService {
	@Autowired
	private productRepository productRepo;

	public Product addProduct(Product product) {
		return productRepo.save(product);

	}

	public List<Product> getAllPrducts() {
		return productRepo.findAll();

	}

	public Optional<Product> getProductById(long id) {

		return productRepo.findById(id);
	}

	public Product updateProduct(long id, Product product) {
		product.setId(id);
		Optional<Product> prdct = productRepo.findById(id);
		if (prdct.isPresent()) {
			Product pr = prdct.get();
			pr.setDescription(product.getDescription() != null ? product.getDescription() : pr.getDescription());
			pr.setName(product.getName() != null ? product.getName() : pr.getName());
			pr.setPrice(product.getPrice() != null ? product.getPrice() : pr.getPrice());
			return pr;

		}
		return null;

	}

	public void deleteProduct(long id) {
		// TODO Auto-generated method stub
		 productRepo.deleteById(id);;
	}

}
