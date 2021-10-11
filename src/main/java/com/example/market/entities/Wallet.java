package com.example.market.entities;

import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "wallet")
public class Wallet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "walletId")
    private int id;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(joinColumns = @JoinColumn(name = "walletId"),
            inverseJoinColumns = @JoinColumn(name = "currencyId"))
    private List<Currency> currencies = new ArrayList<>();
}
