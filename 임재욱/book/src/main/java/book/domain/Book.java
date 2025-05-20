package book.domain;

import jakarta.persistence.*;
import lombok.*;
import book.domain.base.BaseEntity;
import book.domain.mapping.BookHashtag;

import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Book extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = true)
    private String info;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private BookCategory categoryId;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private List<BookHashtag> bookHashtags;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private  List<BookLike> bookLikes;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL)
    private  List<RealBook> realBooks;
}
