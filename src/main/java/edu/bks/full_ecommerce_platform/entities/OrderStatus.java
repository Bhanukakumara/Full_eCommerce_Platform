package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;
import lombok.ToString;

@Entity
@Table(name = "order_status")
public class OrderStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;
}
