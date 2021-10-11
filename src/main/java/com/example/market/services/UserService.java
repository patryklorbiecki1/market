package com.example.market.services;

import com.example.market.dtos.response.UserResponse;
import com.example.market.entities.User;

import java.util.List;


public interface UserService  {
    List<UserResponse> getAllUsers();
    UserResponse getUserByEmail(String email);
}
