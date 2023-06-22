package com.example.market.services;

import com.example.market.dtos.request.CurrencyRequest;
import com.example.market.dtos.response.CurrencyResponse;
import com.example.market.entities.Currency;
import com.example.market.mapper.CurrencyMapper;
import com.example.market.repositories.CurrencyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CurrencyServiceImpl implements CurrencyService {
    private final CurrencyRepository currencyRepository;
    private final CurrencyMapper currencyMapper;

    @Autowired
    public CurrencyServiceImpl(CurrencyRepository currencyRepository, CurrencyMapper currencyMapper) {
        this.currencyRepository = currencyRepository;
        this.currencyMapper = currencyMapper;
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
    public CurrencyResponse addCurrency(CurrencyRequest currencyRequest) {
        Currency currency = new Currency();
        currency.setName(currencyRequest.name());
        currency.setCapitalization(currencyRequest.capitalization());
        currency.setPrice(currencyRequest.price());
        currencyRepository.save(currency);
        return currencyMapper.toCurrencyResponse(currency);
    }

    @Override
    public void remove(String name) {
        currencyRepository.deleteByName(name);
    }
}
