package com.example.demo.domain.mapping;

import com.example.demo.domain.Book;
import com.example.demo.domain.Member;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.example.demo.domain.common.BaseTimeEntity;

@Entity
public class BookRental extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    private LocalDateTime rentalDate;
    private LocalDateTime returnDate;
}
