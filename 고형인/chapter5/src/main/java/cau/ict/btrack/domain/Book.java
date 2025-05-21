package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.mapping.Rent;
import cau.ict.btrack.domain.mapping.BookLikes;
import cau.ict.btrack.domain.mapping.BookTag;
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

    @Column(nullable = false, length = 50)
    private String title;

    @Lob
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "book")
    private List<Rent> rentList = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<BookLikes> bookLikeList = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<BookTag> bookTagList = new ArrayList<>();

}
