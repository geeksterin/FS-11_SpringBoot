package com.geekster.mapping.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

    private String addressName;

   @ManyToMany
   @JoinTable(name = "add_emp_m_m_mappings",
           joinColumns = @JoinColumn(name = "fk_add") ,
           inverseJoinColumns = @JoinColumn(name = "fk_emp"))
   List<Emp> employees;
}
