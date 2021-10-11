package com.example.market.repositories;

import com.example.market.entities.Wallet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WalletRepository extends CrudRepository<Wallet, Integer> {
    Optional<Wallet> findById(int id);
}
