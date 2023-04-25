package com.matchbox.matchboxstickers.dao;

import com.matchbox.matchboxstickers.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
