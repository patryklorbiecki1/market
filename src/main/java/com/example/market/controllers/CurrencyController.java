package com.example.market.controllers;

import com.example.market.dtos.request.CurrencyRequest;
import com.example.market.dtos.response.CurrencyResponse;
import com.example.market.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    private final CurrencyService currencyService;

    @Autowired
    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("all")
    public List<CurrencyResponse> getAll() {
        return currencyService.getAll();
    }

    @GetMapping("{name}")
    public CurrencyResponse getByName(@PathVariable String name) {
        return currencyService.getByName(name);
    }

    @PostMapping("add")
    public CurrencyResponse addCurrency(CurrencyRequest currencyRequest) {
        return currencyService.addCurrency(currencyRequest);
    }

    @DeleteMapping("{name}")
    public void deleteCurrency(String name) {
        currencyService.remove(name);
    }
}
