package com.example.ch2study;

import com.example.ch2study.model.Role;
import com.example.ch2study.model.State;
import com.example.ch2study.model.User;
import com.example.ch2study.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor
public class TestUserRepo {
    private final UserRepo userRepo;
    @Test
    public void addUser() {
        User user = User.builder()
                .firstName("John")
                .lastName("Levy")
                .email("john@gmail.com")
                .password("123")
                .role(Role.STUDENT)
                .state(State.PENDING).build();

        User saveUser = userRepo.save(user);
        assertThat(saveUser).isNotNull();
    }
}
