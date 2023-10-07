package com.projectRaj.eCommerceAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name is required")
    private String name;

    private String landmark;

    @NotBlank(message = "Phone number is required")
    @Pattern(regexp = "\\d{10}", message = "Invalid phone number format (10 digits)")
    private String phoneNumber;

    @NotBlank(message = "Zipcode is required")
    private String zipcode;

    @NotBlank(message = "State is required")
    private String state;

    @OneToOne
    @JoinColumn(name = "fk_user_id")
    private User user;
}

