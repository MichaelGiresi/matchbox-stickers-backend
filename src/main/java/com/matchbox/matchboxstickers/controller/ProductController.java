package com.matchbox.matchboxstickers.controller;

import com.matchbox.matchboxstickers.entity.Product;
import com.matchbox.matchboxstickers.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    // Your ProductService or ProductRepository to fetch the Product from the database
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    // A method to get a Product by its id
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) {
        // Use the ProductService or ProductRepository to fetch a Product from the database
        return productService.findProductById(id);
    }
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }
}
