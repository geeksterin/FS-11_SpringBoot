package com.geekster.Room.APP.model;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name  = "OYO")
public class Room {

    @Id
    private Integer roomId;


    private Integer roomNumber;

    private Type roomType;

    @Column(name = "available")
    private boolean roomAvailable;


    private double roomPrice;
}
