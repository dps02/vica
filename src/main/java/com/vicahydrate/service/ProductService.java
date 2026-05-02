package com.vicahydrate.service;

import com.vicahydrate.model.Product;
import com.vicahydrate.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    // Spring will automatically find the repository and "inject" it here
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllAvailableProducts() {
        return productRepository.findByInStockTrueOrderBySizeLabelAsc();
    }

	public Object getProductById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
}