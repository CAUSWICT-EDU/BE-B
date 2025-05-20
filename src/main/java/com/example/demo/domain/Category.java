package com.example.demo.domain;

import jakarta.persistence.*;
import com.example.demo.domain.common.BaseTimeEntity;

@Entity
public class Category extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
}
