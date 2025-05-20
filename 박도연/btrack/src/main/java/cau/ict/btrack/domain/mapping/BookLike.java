package cau.ict.btrack.domain.mapping;

import cau.ict.btrack.domain.Book;
import cau.ict.btrack.domain.User;
import cau.ict.btrack.domain.common.BaseEntity;
import jakarta.persistence.*;


@Entity
public class BookLike extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
