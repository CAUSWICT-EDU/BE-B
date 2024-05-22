package cau.ict.btrack.domain.like;

import cau.ict.btrack.domain.book.Book;
import cau.ict.btrack.domain.enums.Like;
import cau.ict.btrack.domain.member.Member;
import jakarta.persistence.*;


@Entity
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Like status;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}