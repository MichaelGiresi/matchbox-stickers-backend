package com.matchbox.matchboxstickers.controller;

import com.matchbox.matchboxstickers.entity.ShippingAddress;
import com.matchbox.matchboxstickers.service.ShippingAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shipping_addresses")
public class ShippingAddressController {

    @Autowired
    private ShippingAddressService shippingAddressService;

    @GetMapping
    public ResponseEntity<List<ShippingAddress>> getAllShippingAddresses() {
        List<ShippingAddress> addresses = shippingAddressService.findAll();
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<ShippingAddress> getShippingAddressById(@PathVariable("id") Long id) {
        ShippingAddress address = shippingAddressService.findById(id);
        return new ResponseEntity<>(address, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ShippingAddress> createShippingAddress(@RequestBody ShippingAddress shippingAddress) {
        ShippingAddress newAddress = shippingAddressService.save(shippingAddress);
        return new ResponseEntity<>(newAddress, HttpStatus.CREATED);
    }
}