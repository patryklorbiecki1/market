package com.example.market.services;

import com.example.market.dtos.response.WalletResponse;
import com.example.market.entities.Currency;
import springfox.documentation.service.ResponseMessage;


public interface WalletService {
    WalletResponse getCurrencies(int walletId);
    ResponseMessage addCurrencyToWallet(Currency currency);
}
