package cau.ict.btrack.domain.book;
import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.hashtag.BookHashTag;
import cau.ict.btrack.domain.hashtag.HashTag;
import cau.ict.btrack.domain.like.Likes;
import cau.ict.btrack.domain.rent.Rent;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Book extends BaseEntity {
    @Column(nullable = false, length = 255)
    private String name;

    @Column(columnDefinition = "TEXT")
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
    private Set<Rent> rents;

    @OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
    private Set<Likes> likes;

    @OneToMany(mappedBy = "book" , cascade = CascadeType.ALL)
    private Set<BookHashTag> bookHashTags;
}