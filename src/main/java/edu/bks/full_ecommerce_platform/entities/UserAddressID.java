package edu.bks.full_ecommerce_platform.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAddressID implements Serializable {
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "address_id")
    private Long address_id;
}
