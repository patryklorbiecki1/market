package com.example.market.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Currency;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {
    private String email;
    private String username;
    private Currency money;
}
