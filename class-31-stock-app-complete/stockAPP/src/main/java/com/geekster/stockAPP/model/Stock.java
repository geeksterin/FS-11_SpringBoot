package com.geekster.stockAPP.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Stock {

    @Id
    private Long stockId;

    private String stockName;

    private double stockPrice;

    private int stockOwnerCount;

    @Enumerated(EnumType.STRING)
    private Type stockType;

    private LocalDateTime stockCreationTimeStamp;


}
