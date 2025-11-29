package com.ecommerce.project.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    @NotBlank
    @Size(min = 3, message = "Street name must be 3 character")
    private String street;

    @NotBlank
    @Size(min = 3,message = "Building name must be 3 character")
    private String buildingName;

    @NotBlank
    @Size(min = 4,message = "City name must be 4 character")
    private String city;

    @NotBlank
    @Size(min = 2,message = "state name must be 2 character")
    private String state;

    @NotBlank
    @Size(min = 2,message = "Country name must be 2 character")
    private String country;

    @NotBlank
    @Size(min = 6,message = "pincode name must be 6 character")
    private String pincode;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
