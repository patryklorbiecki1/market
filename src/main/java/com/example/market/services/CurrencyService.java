package com.example.market.services;

import com.example.market.dtos.request.CurrencyRequest;
import com.example.market.dtos.response.CurrencyResponse;
import com.example.market.dtos.response.MessageResponse;
import com.example.market.entities.Currency;

import java.util.List;

public interface CurrencyService {
    List<CurrencyResponse> getAll();
    CurrencyResponse getByName(String name);
    MessageResponse addCurrency(CurrencyRequest currency);
    MessageResponse remove(String name);
}
