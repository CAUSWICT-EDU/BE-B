package com.example.demo.domain;

import com.example.demo.domain.common.BaseTimeEntity;
import com.example.demo.domain.common.Gender;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String nickname;
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    private String status;
    private LocalDateTime inactiveDate;
}
