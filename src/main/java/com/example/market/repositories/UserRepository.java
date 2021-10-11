package com.example.market.repositories;

import com.example.market.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    Optional<User> getUserByEmail(String email);
    boolean existsByEmail(String email);
    boolean existsByUsername(String username);
}
