package com.matchbox.matchboxstickers.service.impl;

import com.matchbox.matchboxstickers.entity.Customer;
import com.matchbox.matchboxstickers.dao.CustomerRepository;
import com.matchbox.matchboxstickers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}