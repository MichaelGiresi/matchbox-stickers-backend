package com.matchbox.matchboxstickers.service;


import com.matchbox.matchboxstickers.entity.ShippingAddress;

import java.util.List;

public interface ShippingAddressService {

    List<ShippingAddress> findAll();
    ShippingAddress findById(Long id);
    ShippingAddress save(ShippingAddress shippingAddress);
}