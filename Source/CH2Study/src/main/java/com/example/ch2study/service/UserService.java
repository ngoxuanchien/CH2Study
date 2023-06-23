package com.example.ch2study.service;

import com.example.ch2study.exception.UserAlreadyExistsException;
import com.example.ch2study.model.CH2StudyUser;
import com.example.ch2study.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;

    public List<CH2StudyUser> getAllUsers() {
        return new ArrayList<>(userRepo.findAll());
    }

    public CH2StudyUser createNewUser(CH2StudyUser newUser) {
        if (!userRepo.existsByEmail(newUser.getEmail())) {
            userRepo.save(newUser);
            return newUser;
        } else {
            throw new UserAlreadyExistsException("Email da ton tai");
        }
    }

    public CH2StudyUser getUser(Long userId) {
        Optional<CH2StudyUser> optionalCH2StudyUser = userRepo.findById(userId);
        if (optionalCH2StudyUser.isPresent()) {

            return optionalCH2StudyUser.get();
        } else {
            throw new NotFoundException("khong tim thay user");
        }
    }

    public CH2StudyUser updateUser(Long userId, CH2StudyUser newUser) {
        Optional<CH2StudyUser> optionalCH2StudyUser = userRepo.findById(userId);
        if (optionalCH2StudyUser.isPresent()) {
            CH2StudyUser user = optionalCH2StudyUser.get();

            user.setFirstName(newUser.getFirstName());
            user.setLastName(newUser.getLastName());
            user.setBirthDay(newUser.getBirthDay());
            user.setPassword(newUser.getPassword());
            user.setEmail(newUser.getEmail());
            user.setRole(newUser.getRole());
            user.setState(newUser.getState());
            return userRepo.save(user);
        } else {
            throw new NotFoundException("khong tim thay user");
        }
    }

    public CH2StudyUser deleteUser(Long userId) {
        Optional<CH2StudyUser> optionalCH2StudyUser = userRepo.findById(userId);
        if (optionalCH2StudyUser.isPresent()) {
            CH2StudyUser user = optionalCH2StudyUser.get();

            userRepo.delete(user);
            return user;
        } else {
            throw new NotFoundException("khong tim thay user");
        }
    }
}
