package com.example.ch2study.repository;

import com.example.ch2study.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.concurrent.ConcurrentHashMap;

public interface UserRepo extends JpaRepository<User, Integer> {
}
