package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Create user endpoint
//    @PostMapping
//    public String createUser(@RequestBody User user) {
//        return userService.createUser(user);
//    }

    // Search user by email endpoint
    @GetMapping("/search")
    public String searchUserByEmail(@RequestParam String email) {
        try {
            User user = userService.getUserByEmail(email);
            return user != null ? "User found: " + user.getName() : "User not found.";
        } catch (IllegalStateException e) {
            return "Error: " + e.getMessage();
        }
    }
}
