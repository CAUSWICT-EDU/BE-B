package cau.ict.btrack.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    private String subject;

    private String description;

    private String author;

    @Enumerated(EnumType.STRING)
    private BookCategory Category;

    @OneToMany(mappedBy = "book")
    private List<Rent> rents;

    @OneToMany(mappedBy = "book")
    private List<HashTagMap> hashTagMaps;
}
