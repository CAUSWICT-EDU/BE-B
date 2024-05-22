package cau.ict.btrack.domain.book;
import jakarta.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column
    private Integer count;

    @OneToMany(mappedBy = "category")
    private Set<Book> books;

}