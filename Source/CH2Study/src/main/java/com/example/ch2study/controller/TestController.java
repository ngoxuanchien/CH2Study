package com.example.ch2study.controller;

import com.example.ch2study.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @RequestMapping("/hello-world")
    public String helloWord() {
        return "Hello world";
    }
}
