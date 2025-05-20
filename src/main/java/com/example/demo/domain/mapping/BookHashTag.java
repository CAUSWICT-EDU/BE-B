package com.example.demo.domain.mapping;

import com.example.demo.domain.Book;
import com.example.demo.domain.HashTag;
import jakarta.persistence.*;

@Entity
public class BookHashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne
    @JoinColumn(name = "hash_tag_id")
    private HashTag hashTag;
}
