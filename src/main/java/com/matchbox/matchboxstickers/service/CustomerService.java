package com.matchbox.matchboxstickers.service;

import com.matchbox.matchboxstickers.entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> findAll();
    Customer findById(Long id);
    Customer save(Customer customer);
}
