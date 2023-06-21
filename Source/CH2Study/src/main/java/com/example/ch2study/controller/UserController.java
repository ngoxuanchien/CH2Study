package com.example.ch2study.controller;

import com.example.ch2study.model.CH2StudyUser;
import com.example.ch2study.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<CH2StudyUser>> getUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CH2StudyUser> getUser(@PathVariable("id") Integer userId) {
        try {
            CH2StudyUser user = userService.getUser(userId);
            return ResponseEntity.ok(user);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public CH2StudyUser addUser(@RequestParam String username,
                                @RequestParam String password) {
        return userService.createNewUser(username, password);
    }

    @PutMapping(value="/{id}")
    public ResponseEntity<CH2StudyUser> updateUser(@PathVariable("id") Integer userId,
                                   @RequestBody CH2StudyUser newUser
    ) {
        try {
            CH2StudyUser user = userService.updateUser(userId ,newUser);
            return ResponseEntity.ok(user);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(value="/{id}")
    public ResponseEntity<CH2StudyUser> deleteUser(@PathVariable("id") Integer userId) {
        try {
            CH2StudyUser user = userService.deleteUser(userId);
            return ResponseEntity.ok(user);
        } catch (NotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
