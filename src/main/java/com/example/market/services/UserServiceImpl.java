package com.example.market.services;

import com.example.market.dtos.request.UserRequest;
import com.example.market.dtos.response.MessageResponse;
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
        if(userRepository.getUserByEmail(email).isPresent()) {
            User user =  userRepository.getUserByEmail(email).get();
            return new UserResponse(user.getEmail(),user.getUsername(),user.getMoney());
        }
        else return null;
    }

    @Override
    public MessageResponse addUser(UserRequest userRequest) {
        if(userRepository.existsByEmail(userRequest.getEmail()))
            return new MessageResponse("Email exists!");
        else if(userRepository.existsByUsername(userRequest.getUsername()))
            return new MessageResponse("Username exists!");
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setEmail(userRequest.getEmail());
        user.setMoney(userRequest.getMoney());
        userRepository.save(user);
        return new MessageResponse("User created!");
    }
}
