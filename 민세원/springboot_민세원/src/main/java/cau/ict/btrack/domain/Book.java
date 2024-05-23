package cau.ict.btrack.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String subject;

    @Column(nullable = false, length = 1000)
    private String description;

    @Column(nullable = false, length = 100)
    private String author;

    @Enumerated(EnumType.STRING)
    private BookCategory Category;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<Rent> rents;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<HashTagMap> hashTagMaps = new ArrayList<>();
}
