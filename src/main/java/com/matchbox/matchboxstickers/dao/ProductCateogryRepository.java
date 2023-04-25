package com.matchbox.matchboxstickers.dao;

import com.matchbox.matchboxstickers.entity.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCateogryRepository extends JpaRepository<ProductCategory, Long> {
}
