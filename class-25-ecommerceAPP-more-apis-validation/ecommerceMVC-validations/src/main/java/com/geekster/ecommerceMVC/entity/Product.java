package com.geekster.ecommerceMVC.entity;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {


    @NotNull(message = "id of the product should not be null!!!")
    private Integer productId;

    //@NotEmpty(message = "Name of the product should not be empty!!!")
    @NotBlank(message = "Name of the product should not be blank!!!")
    @Size(min = 5,max = 10)
    private String productName;

    @Pattern(regexp = "^product: .+")
    private String productDescription;

    private double productPrice;

    private Category productCategory;


}
