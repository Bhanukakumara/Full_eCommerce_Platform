package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "user_revires")
public class UserReview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long orderedProductId;
    private Integer rating;
    private String comment;
}
