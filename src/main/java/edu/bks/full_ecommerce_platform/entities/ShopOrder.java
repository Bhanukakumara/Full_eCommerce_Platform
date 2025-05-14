package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "shop_order")
public class ShopOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private LocalDateTime orderDate;
    private Long paymentMethodId;
    private Long shippingAddressId;
    private Long shippingMethodId;
    private BigDecimal orderTotal;
    private Long orderStatus;
}

