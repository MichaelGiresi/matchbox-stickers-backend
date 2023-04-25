package com.matchbox.matchboxstickers.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "order_tracking_number")
    private Long orderTrackingNumber;

    @Column(name = "total_price")
    private BigDecimal totalPrice;

    @Column(name = "total_quantity")
    private int totalQuantity;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "shipping_address_id", nullable = false)
    private ShippingAddress shippingAddressId;

    @Column(name = "status")
    private Boolean status;

    @Column(name = "date_created")
    @CreationTimestamp
    private Date dateCreated;

    @Column (name = "last_updated")
    @UpdateTimestamp
    private Date lastUpdated;
}
