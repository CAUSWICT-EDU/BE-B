package cau.ict.btrack.domain.hashtag;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class HashTag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @OneToMany(mappedBy = "hashTag",cascade = CascadeType.ALL)
    private List<BookHashTag> BookHashTags;
}