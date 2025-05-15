package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_revires")
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id" , nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ordered_product_id", nullable = false)
    private OrderLine orderLine;

    private Integer rating;
    private String comment;
}
