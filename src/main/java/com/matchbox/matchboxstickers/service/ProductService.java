package com.matchbox.matchboxstickers.service;

import com.matchbox.matchboxstickers.dao.ProductRepository;
import com.matchbox.matchboxstickers.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product findProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        existingProduct.setQuantity(product.getQuantity());
        // Repeat the above line for all fields that can be updated
        return productRepository.save(existingProduct);
    }

    // New method to get all products
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
