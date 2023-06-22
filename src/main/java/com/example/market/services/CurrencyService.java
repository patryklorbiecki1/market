package com.example.market.services;

import com.example.market.dtos.request.CurrencyRequest;
import com.example.market.dtos.response.CurrencyResponse;

import java.util.List;

public interface CurrencyService {
    List<CurrencyResponse> getAll();
    CurrencyResponse getByName(String name);
    CurrencyResponse addCurrency(CurrencyRequest currency);
    void remove(String name);
}
