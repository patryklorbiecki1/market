package com.example.market.services;

import com.example.market.dtos.request.CurrencyRequest;
import com.example.market.dtos.response.CurrencyResponse;
import com.example.market.dtos.response.MessageResponse;
import com.example.market.entities.Currency;
import com.example.market.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @Override
    public List<CurrencyResponse> getAll() {
        return StreamSupport.stream(currencyRepository.findAll().spliterator(),false)
                .map(x -> new CurrencyResponse(
                        x.getName(),
                        x.getPrice(),
                        x.getCapitalization()))
                .collect(Collectors.toList());
    }

    @Override
    public CurrencyResponse getByName(String name) {
        if(currencyRepository.findByName(name).isPresent()){
            Currency currency = currencyRepository.findByName(name).get();
            return new CurrencyResponse(
                    currency.getName(),
                    currency.getPrice(),
                    currency.getCapitalization()
            );
        }
        else{
            return null;
        }
    }

    @Override
    public MessageResponse addCurrency(CurrencyRequest currencyRequest) {
        if(currencyRepository.existsByName(currencyRequest.getName()))
            return new MessageResponse("Currency exists!");

        Currency currency = new Currency();
        currency.setName(currencyRequest.getName());
        currency.setCapitalization(currencyRequest.getCapitalization());
        currency.setPrice(currencyRequest.getPrice());
        currencyRepository.save(currency);
        return new MessageResponse("Currency created!");
    }

    @Override
    public MessageResponse remove(String name) {
        currencyRepository.deleteByName(name);
        return new MessageResponse("Currency: " + name + " was deleted!");
    }
}
