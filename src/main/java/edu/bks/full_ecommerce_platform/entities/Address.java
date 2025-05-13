package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "unit_number")
    private String unitNumber;

    @Column(name = "street_number")
    private String streetNumber;

    @Column(name = "address_line1", nullable = false)
    @NotBlank(message = "Address line 1 is required")
    private String addressLine1;

    @Column(name = "address_line2")
    private String addressLine2;

    @Column(nullable = false)
    @NotBlank(message = "City is required")
    private String city;

    private String region;

    @Column(name = "postal_code", nullable = false)
    @NotBlank(message = "Postal code is required")
    private String postalCode;

    @OneToMany(mappedBy = "address", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserAddress> userAddresses;
}
