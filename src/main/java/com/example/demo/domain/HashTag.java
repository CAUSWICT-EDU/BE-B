package com.example.demo.domain;

import com.example.demo.domain.mapping.BookHashTag;
import jakarta.persistence.*;
import com.example.demo.domain.common.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class HashTag extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "hashTag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookHashTag> bookHashTags = new ArrayList<>();
}
