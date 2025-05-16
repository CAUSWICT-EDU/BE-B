package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.mapping.Rent;
import cau.ict.btrack.domain.mapping.bookLikes;
import cau.ict.btrack.domain.mapping.bookTag;
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

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Rent> rentList = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<bookLikes> bookLikeList = new ArrayList<>();

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<bookTag> bookTagList = new ArrayList<>();

}
