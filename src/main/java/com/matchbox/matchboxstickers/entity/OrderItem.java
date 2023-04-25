package com.matchbox.matchboxstickers.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "order_items")
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "quantity")
    private long quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @ManyToOne
    @JoinColumn (name= "order_id", nullable = false)
    private Order orderId;

    @ManyToOne
    @JoinColumn(name = "product_id",nullable = false)
    private ProductCategory productId;
}
