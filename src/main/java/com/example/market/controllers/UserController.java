package com.example.market.controllers;

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
    public ResponseEntity<List<UserResponse>> getAll(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }
    @GetMapping("{email}")
    public ResponseEntity<UserResponse> getByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }
}
