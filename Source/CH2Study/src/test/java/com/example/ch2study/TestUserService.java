package com.example.ch2study;

import com.example.ch2study.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TestUserService {
    private final UserService userService;

    public TestUserService(UserService userService) {
        this.userService = userService;
    }

    @Test
    public void TestAddUser() {

    }
}
