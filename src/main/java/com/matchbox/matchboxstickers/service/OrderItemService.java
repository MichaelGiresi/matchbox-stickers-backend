package com.matchbox.matchboxstickers.service;

import com.matchbox.matchboxstickers.entity.OrderItem;

import java.util.List;

public interface OrderItemService {
    List<OrderItem> getAllOrderItems();
    OrderItem createOrderItem(OrderItem orderItem);
}