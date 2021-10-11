package com.example.market.entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "currency")
public class Currency {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private int currencyId;
    private String name;
    private float price;
    private float capitalization;

}
