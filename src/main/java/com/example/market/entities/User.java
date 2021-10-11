package com.example.market.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username")
})
public class User {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO )
    private int id;
    private String email;
    private String username;
    private float money;


}
