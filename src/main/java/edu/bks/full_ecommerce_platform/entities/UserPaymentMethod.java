package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_payment_method")
public class UserPaymentMethod {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long paymentTypeId;
    private String provider;
    private int accountNumber;
    private LocalDateTime expiryDate;
    private boolean isDefault;
}
