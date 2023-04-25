package com.matchbox.matchboxstickers.dao;

import com.matchbox.matchboxstickers.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
