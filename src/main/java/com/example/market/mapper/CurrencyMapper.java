package com.example.market.mapper;

import com.example.market.dtos.response.CurrencyResponse;
import com.example.market.entities.Currency;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CurrencyMapper {

    CurrencyResponse toCurrencyResponse(Currency currency);
}
