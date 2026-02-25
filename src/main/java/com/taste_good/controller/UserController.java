package com.taste_good.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.taste_good.dto.LoginUser;
import com.taste_good.dto.RegisterUser;
import com.taste_good.model.User;
import com.taste_good.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<User> registerUser(@RequestBody RegisterUser registerUser) {
        User savedUser = userService.registerUser(registerUser);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<User> loginUser(@RequestBody LoginUser loginUser) {
        User user = userService.loginUser(loginUser);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteUser(@RequestBody LoginUser loginUser) {
        String message = userService.deleteUser(loginUser);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }
}