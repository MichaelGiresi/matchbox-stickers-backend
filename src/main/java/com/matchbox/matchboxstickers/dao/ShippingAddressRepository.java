package com.matchbox.matchboxstickers.dao;

import com.matchbox.matchboxstickers.entity.ShippingAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
}
