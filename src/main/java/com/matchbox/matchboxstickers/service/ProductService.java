package com.matchbox.matchboxstickers.service;

// ProductService.java
import com.matchbox.matchboxstickers.dao.ProductRepository;
import com.matchbox.matchboxstickers.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
