package com.example.ch2study.controller;

import com.example.ch2study.model.CH2StudyUser;
import com.example.ch2study.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    UserService userService;
    @GetMapping({"/","/home", "/status"})
    public String getStatus() {
        return "Application is running";
    }

    @PostMapping
    public ResponseEntity<CH2StudyUser> loginUser(@RequestParam String username,
                                                  @RequestParam String password) {

        return ResponseEntity.ok(new CH2StudyUser());
    }
}
