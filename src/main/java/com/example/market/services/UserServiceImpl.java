package com.example.market.services;

import com.example.market.dtos.request.UserRequest;
import com.example.market.dtos.response.UserResponse;
import com.example.market.entities.User;
import com.example.market.mapper.UserMapper;
import com.example.market.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return StreamSupport.stream(userRepository.findAll().spliterator(),false)
                .map(user -> new UserResponse(user.getEmail(),user.getUsername(),user.getMoney()))
                .collect(Collectors.toList());
    }

    @Override
    public UserResponse getUserByEmail(String email) {
        if(userRepository.getUserByEmail(email).isPresent()) {
            User user =  userRepository.getUserByEmail(email).get();
            return new UserResponse(user.getEmail(),user.getUsername(),user.getMoney());
        }
        else return null;
    }

    @Override
    public UserResponse addUser(UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.username());
        user.setEmail(userRequest.email());
        user.setMoney(userRequest.money());
        userRepository.save(user);
        return userMapper.toUserResponse(user);
    }
}
