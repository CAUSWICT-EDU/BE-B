package cau.ict.btrack.domain.hashtag;

import cau.ict.btrack.domain.book.Book;
import jakarta.persistence.*;
@Entity
public class BookHashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "hashtag_id", nullable = false)
    private HashTag hashTag;
}
