package com.matchbox.matchboxstickers.service.impl;

import com.matchbox.matchboxstickers.entity.ShippingAddress;
import com.matchbox.matchboxstickers.dao.ShippingAddressRepository;
import com.matchbox.matchboxstickers.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShippingAddressServiceImpl implements ShippingAddressService {

    private final ShippingAddressRepository repository;

    @Autowired
    public ShippingAddressServiceImpl(ShippingAddressRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<ShippingAddress> findAll() {
        return repository.findAll();
    }

    @Override
    public ShippingAddress findById(Long id) {
        Optional<ShippingAddress> address = repository.findById(id);
        return address.orElse(null);
    }

    @Override
    public ShippingAddress save(ShippingAddress shippingAddress) {
        return repository.save(shippingAddress);
    }
}