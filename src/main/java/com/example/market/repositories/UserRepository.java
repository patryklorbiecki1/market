package com.example.market.repositories;

import com.example.market.dtos.response.UserResponse;
import com.example.market.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    UserResponse getUserByEmail(String email);
}
