package com.example.market.controllers;

import com.example.market.dtos.request.UserRequest;
import com.example.market.dtos.response.UserResponse;
import com.example.market.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("all")
    public List<UserResponse> getAll(){
        return userService.getAllUsers();
    }
    @GetMapping("{email}")
    public UserResponse getByEmail(@PathVariable String email){
        return userService.getUserByEmail(email);
    }
    @PostMapping("add")
    public UserResponse addUser(@RequestBody UserRequest user){
        return userService.addUser(user);
    }
}
