package com.projectRaj.eCommerceAPI.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.ListIterator;

@Data
@Validated
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    //todo : doesn't make sense : should have been <many-orders to one-user>
    @ManyToMany
    @JoinColumn(name = "fk_user_id")
    private List<User> users;// should be just User user


    //todo : 1-m orders -> product or m-1 in the product class
    @ManyToMany
    @JoinColumn(name = "fk_product_id")
    private List<Product> products; //1-m

    //todo :m-orders - 1 address (m-1)
    @ManyToMany
    @JoinColumn(name = "fk_address_id")
    private List<Address> addresses;// list not required


    //todo : maybe this should just be exposed via the get call : and not be updatable via any api
    @NotNull(message = "Product quantity is required")
    @Min(value = 1, message = "Product quantity must be at least 1")
    private Integer productQuantity;
}

