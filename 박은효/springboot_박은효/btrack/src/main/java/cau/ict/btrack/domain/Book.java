package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 40)
    private String name;

    private String description;

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<Rent> rentList = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<BookHashTag> bookHashTagList = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.PERSIST)
    private List<BookLikes> bookLikesList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_category_id")
    private BookCategory bookCategory;
}
