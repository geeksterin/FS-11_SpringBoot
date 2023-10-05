package com.geekster.m_11_m.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String productName;

    @Enumerated(value = EnumType.STRING)
    private Category productCategory;


    @ManyToOne
    @JoinColumn(name = "Fk_order_id" )
    Order order;
}
