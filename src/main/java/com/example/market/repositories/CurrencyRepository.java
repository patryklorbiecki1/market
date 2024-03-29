package com.example.market.repositories;

import com.example.market.entities.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency,Integer> {
    Optional<Currency> findByName(String name);
    void deleteByName(String name);
}
