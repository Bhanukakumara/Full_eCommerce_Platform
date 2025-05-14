package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "variation_option")
public class VariationOption {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "variation_id", nullable = false)
    @NotNull(message = "Variation is required")
    private Variation variation;

    @Column(nullable = false)
    @NotBlank(message = "Option value is required")
    @Size(max = 50, message = "Option value must be less than 50 characters")
    private String value;

    @ManyToMany(mappedBy = "variationOptions")
    private Set<ProductItem> productItems = new HashSet<ProductItem>();
}
