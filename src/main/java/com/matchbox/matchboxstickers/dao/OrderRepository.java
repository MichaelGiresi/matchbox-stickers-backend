package com.matchbox.matchboxstickers.dao;

import com.matchbox.matchboxstickers.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
