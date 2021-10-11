package com.example.market.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Currency;

@Entity
@Data
@Table(name = "user", uniqueConstraints = {
        @UniqueConstraint(columnNames = "email"),
        @UniqueConstraint(columnNames = "username")
})
public class User {
    @Id
    @GeneratedValue(generator = "uuid")
    private Long id;
    private String email;
    private String username;
    private Currency money;


}
