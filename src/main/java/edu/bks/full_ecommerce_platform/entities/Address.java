package edu.bks.full_ecommerce_platform.entities;

import edu.bks.full_ecommerce_platform.enums.AddressType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "addresses'")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_number", length = 20)
    @Size(max = 20, message = "Unit number cannot exceed 20 characters")
    private String unitNumber;

    @Column(name = "street_number", length = 20)
    @Size(max = 20, message = "Street number cannot exceed 20 characters")
    private String streetNumber;

    @Column(name = "address_line_1", nullable = false, length = 100)
    @NotBlank(message = "Address line 1 is required")
    @Size(min = 3, max = 100, message = "Address line 1 must be between 3 and 100 characters")
    private String addressLine1;

    @Column(name = "address_line_2", length = 100)
    @Size(max = 100, message = "Address line 2 cannot exceed 100 characters")
    private String addressLine2;

    @Column(name = "city", nullable = false, length = 50)
    @NotBlank(message = "City is required")
    @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
    private String city;

    @Column(name = "state_province", length = 50)
    @Size(max = 50, message = "State/Province cannot exceed 50 characters")
    private String stateProvince;

    @Column(name = "postal_code", nullable = false, length = 20)
    @NotBlank(message = "Postal code is required")
    @Size(max = 5, message = "Postal code must be between 3 and 20 characters")
    private int postalCode;

    @Column(name = "address_type", length = 20)
    @Enumerated(EnumType.STRING)
    private AddressType addressType;

    @Column(name = "delivery_instructions", length = 500)
    @Size(max = 500, message = "Delivery instructions cannot exceed 500 characters")
    private String deliveryInstructions;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "created_by",updatable = false)
    private Long createdBy;

    @Column(name = "updated_by")
    private Long updatedBy;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAddress> userAddresses;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", nullable = false)
    @NotNull(message = "Country is required")
    private Country country;
}
