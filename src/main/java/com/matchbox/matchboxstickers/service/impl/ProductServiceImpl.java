package com.matchbox.matchboxstickers.service.impl;

import com.matchbox.matchboxstickers.dao.ProductRepository;
import com.matchbox.matchboxstickers.entity.Product;
import com.matchbox.matchboxstickers.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Product findProductById(Long productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        Product existingProduct = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product not found"));
        existingProduct.setQuantity(product.getQuantity());
        // Repeat the above line for all fields that can be updated
        return productRepository.save(existingProduct);
    }

    @Override
    public void deleteProduct(Long id) {
        System.out.println("Deleting product with id: " + id);
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
