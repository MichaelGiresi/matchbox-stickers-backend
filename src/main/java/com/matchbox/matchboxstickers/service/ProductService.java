package com.matchbox.matchboxstickers.service;

import com.matchbox.matchboxstickers.entity.Product;
import java.util.List;

public interface ProductService {
    Product findProductById(Long productId);
    Product updateProduct(Long id, Product product);
    void deleteProduct(Long id);
    List<Product> findAll();

}