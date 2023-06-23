package com.example.ch2study;

import com.example.ch2study.exception.UserAlreadyExistsException;
import com.example.ch2study.model.CH2StudyUser;
import com.example.ch2study.model.Role;
import com.example.ch2study.repository.UserRepo;
import com.example.ch2study.service.UserService;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.webjars.NotFoundException;

import java.sql.Date;
import java.util.Optional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class TestUserService {

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepo userRepo;

    @Test
    @Transactional
    public void addUser() {
        CH2StudyUser newUser = CH2StudyUser
                .builder()
                .firstName("Thanh")
                .lastName("Huynh")
                .birthDay(Date.valueOf("2002-06-25"))
                .email("huynhthanh@gmail.com")
                .password("password")
                .role(Role.STUDENT)
                .build();

        try {
            CH2StudyUser user = userService.createNewUser(newUser);
            assertThat(user).isNotNull();
            assertThat(user.getId()).isNotNull();
            assertThat(user.getFirstName()).isEqualTo(newUser.getFirstName());
            assertThat(user.getLastName()).isEqualTo(newUser.getLastName());
            assertThat(user.getBirthDay()).isEqualTo(newUser.getBirthDay());
            assertThat(user.getEmail()).isEqualTo(newUser.getEmail());
            assertThat(user.getPassword()).isEqualTo(newUser.getPassword());
            assertThat(user.getRole()).isEqualTo(Role.STUDENT);
            System.out.println(user);

            assertThat(userRepo.findById(user.getId())).isNotEmpty();
        } catch (UserAlreadyExistsException e) {
            System.out.println(e.getMessage());
        }
    }

    @Test
    @Transactional
    public void getUser() {
        Long userId = 1L;

        try {
            CH2StudyUser user = userService.getUser(userId);
            assertThat(user).isNotNull();

            Optional<CH2StudyUser> repoUser = userRepo.findById(userId);
            assertThat(repoUser).isNotEmpty();
            assertThat(repoUser.get()).isEqualTo(user);

            System.out.println(user);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    @Transactional
    public void removeUser() {
        Long userId = 1L;

        try {
            CH2StudyUser userDelete = userService.getUser(userId);
            CH2StudyUser user = userService.deleteUser(userId);
            assertThat(user).isNotNull();
            assertThat(user).isEqualTo(userDelete);
            System.out.println(user);

            Optional<CH2StudyUser> userFind = userRepo.findById(userId);
            assertThat(userFind).isEmpty();
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Test
    @Transactional
    public void updateUser() {
        Long id = 1L;
        CH2StudyUser newUser = CH2StudyUser
                .builder()
                .firstName("Thanh")
                .lastName("Huynh")
                .birthDay(Date.valueOf("2002-06-25"))
                .email("huynhthanh@gmail.com")
                .password("password")
                .role(Role.STUDENT)
                .build();
        try {
            CH2StudyUser user = userService.updateUser(id, newUser);

            assertThat(user).isNotNull();
            assertThat(user.getFirstName()).isEqualTo(newUser.getFirstName());
            assertThat(user.getLastName()).isEqualTo(newUser.getLastName());
            assertThat(user.getBirthDay()).isEqualTo(newUser.getBirthDay());
            assertThat(user.getEmail()).isEqualTo(newUser.getEmail());
            assertThat(user.getPassword()).isEqualTo(newUser.getPassword());
            assertThat(user.getRole()).isEqualTo(Role.STUDENT);

            System.out.println(user);
        } catch (NotFoundException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
