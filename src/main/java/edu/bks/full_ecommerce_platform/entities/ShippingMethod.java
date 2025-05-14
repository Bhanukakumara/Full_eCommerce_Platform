package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "shpinng_method")
public class ShippingMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal price;
}
