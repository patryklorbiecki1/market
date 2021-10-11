package com.example.market.controllers;

import com.example.market.dtos.request.CurrencyRequest;
import com.example.market.dtos.response.CurrencyResponse;
import com.example.market.services.CurrencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<CurrencyResponse>> getAll(){
        return new ResponseEntity<>(currencyService.getAll(), HttpStatus.OK);
    }

    @GetMapping("{name}")
    public ResponseEntity<CurrencyResponse> getByName(@PathVariable String name){
        return new ResponseEntity<>(currencyService.getByName(name),HttpStatus.OK);
    }
    @PostMapping("add")
    public ResponseEntity addCurrency(CurrencyRequest currencyRequest){
        return ResponseEntity.ok(currencyService.addCurrency(currencyRequest));
    }
    @DeleteMapping("{name}")
    public ResponseEntity deleteCurrency(String name){
        return ResponseEntity.ok(currencyService.remove(name));
    }
}
