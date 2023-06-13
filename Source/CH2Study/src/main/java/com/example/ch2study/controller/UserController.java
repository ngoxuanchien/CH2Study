package com.example.ch2study.controller;

import com.example.ch2study.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ConcurrentHashMap;

@RestController
@RequestMapping("/user")
public class UserController {

    private ConcurrentHashMap<String, User> users;

    public UserController() {
        users = new ConcurrentHashMap<>();
    }

    @GetMapping(value = "/{id}")
    public User getUser(@PathVariable("id") String id) {
        return users.get(id);
    }

    @PutMapping(value="/{id}")
    public User updateUser(
            @PathVariable("id") String id,
            @RequestBody User userUpdate
    ) {
        return userUpdate;
    }

    @DeleteMapping(value="/{id}")
    public User deleteUser(
            @PathVariable("id") String id
    ) {
        User userDelete = users.remove(id);
        return userDelete;
    }


}
