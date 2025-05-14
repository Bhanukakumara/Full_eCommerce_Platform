package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "product_item")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    @NotNull(message = "Product is required")
    private Product product;

    @Column(nullable = false, unique = true)
    @NotBlank(message = "SKU is required")
    private String SKU;

    @Column(name = "qty_in_stock", nullable = false)
    @Min(value = 0, message = "Quantity cannot be negative")
    private Integer qtyInStock;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(nullable = false)
    @DecimalMin(value = "0.0", inclusive = false, message = "Price must be greater than 0")
    @Digits(integer = 10, fraction = 2, message = "Price must have up to 2 decimal places")
    private BigDecimal price;

    @ManyToMany
    @JoinTable(
            name = "product_configuration",
            joinColumns = @JoinColumn(name = "product_item_id"),
            inverseJoinColumns = @JoinColumn(name = "variation_id")
    )
    private Set<VariationOption> variationOptions = new HashSet<>();
}
