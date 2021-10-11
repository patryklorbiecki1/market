package com.example.market.services;

import com.example.market.dtos.response.WalletResponse;
import com.example.market.entities.Currency;
import com.example.market.entities.Wallet;
import com.example.market.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.service.ResponseMessage;


@Service
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    @Autowired
    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    @Override
    public WalletResponse getCurrencies(int walletId) {
        if(walletRepository.findById(walletId).isPresent()){
            Wallet wallet = walletRepository.findById(walletId).get();
            return new WalletResponse(
                    wallet.getCurrencies()
            );
        }
        else{
            return null;
        }
    }

    @Override
    public ResponseMessage addCurrencyToWallet(Currency currency) {
        return null;
    }
}
