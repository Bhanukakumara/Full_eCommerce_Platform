package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "order_line")
public class OrderLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productItemId;
    private Long orderId;
    private Long quantity;
    private BigDecimal price;
}
