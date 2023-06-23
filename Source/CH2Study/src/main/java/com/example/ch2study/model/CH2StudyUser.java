package com.example.ch2study.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table
public class CH2StudyUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private Date birthDay;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private double coin = 0;

    @Column(nullable = false)
    private Role role;

    private State state;
}
