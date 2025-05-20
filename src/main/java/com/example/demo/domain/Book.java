package com.example.demo.domain;

import com.example.demo.domain.mapping.BookHashTag;
import jakarta.persistence.*;
import com.example.demo.domain.common.BaseTimeEntity;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Lob
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookHashTag> bookHashTags = new ArrayList<>();
}