package com.example.market.dtos.response;

import com.example.market.entities.Currency;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WalletResponse {
    private List<Currency> currencies;
}
