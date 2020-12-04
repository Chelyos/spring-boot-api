package com.api.api.controller;

import com.api.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.api.api.service.UserService;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public Optional<User> index(@RequestParam("email") final String email) {
        return userService.getUsers(email);
    }

    @PostMapping("/user/sign-up")
    public User signUp(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PostMapping("/user/sign-in")
    public User signIn(@RequestBody User user){
        return userService.registerUser(user);
    }
}
