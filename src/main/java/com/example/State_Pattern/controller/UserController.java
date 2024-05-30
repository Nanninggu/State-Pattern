package com.example.State_Pattern.controller;

import com.example.State_Pattern.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/{id}/state")
    public ResponseEntity<Void> changeUserState(@PathVariable("id") String id) {
        userService.changeUserState(id);
        return ResponseEntity.noContent().build();
    }
}