package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_cart_item")
public class ShoppingCartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cartId;
    private Long productItemId;
    private int quantity;
}
