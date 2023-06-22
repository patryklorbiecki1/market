package com.example.market.services;

import com.example.market.dtos.request.UserRequest;
import com.example.market.dtos.response.UserResponse;

import java.util.List;


public interface UserService  {
    List<UserResponse> getAllUsers();
    UserResponse getUserByEmail(String email);
    UserResponse addUser(UserRequest userRequest);
}
