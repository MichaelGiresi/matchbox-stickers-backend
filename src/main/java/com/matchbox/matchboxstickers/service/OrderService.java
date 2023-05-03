package com.matchbox.matchboxstickers.service;

import com.matchbox.matchboxstickers.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> findAllOrders();
    Order findOrderById(Long id);
    Order createOrder(Order order);
}