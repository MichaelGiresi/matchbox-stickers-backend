package com.matchbox.matchboxstickers.dao;

import com.matchbox.matchboxstickers.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
