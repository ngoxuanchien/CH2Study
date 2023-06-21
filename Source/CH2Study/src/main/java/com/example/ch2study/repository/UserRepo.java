package com.example.ch2study.repository;

import com.example.ch2study.model.CH2StudyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepo extends JpaRepository<CH2StudyUser, Integer> {
}
