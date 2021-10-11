package com.example.market.services;

import com.example.market.dtos.response.UserResponse;
import com.example.market.entities.User;
import com.example.market.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .map(user -> new UserResponse(user.getEmail(),user.getUsername(),user.getMoney()))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }
}
