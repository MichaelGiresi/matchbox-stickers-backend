package com.matchbox.matchboxstickers.service.impl;

import com.matchbox.matchboxstickers.dao.OrderRepository;
import com.matchbox.matchboxstickers.entity.Order;
import com.matchbox.matchboxstickers.service.OrderService;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<Order> findAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Order findOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Order not found with id " + id));
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }
}
