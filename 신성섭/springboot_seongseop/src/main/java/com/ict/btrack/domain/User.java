package com.ict.btrack.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {


    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id; // 기본키

    private String name; // 닉네임

    private int height; // 키

    private int weight; // 몸무게

    private int gender; // 성별 (0, 1)

    private int age; // 나이

    public User(String name, int height, int weight, int gender, int age) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.age = age;
    }
}