package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import lombok.*;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "category", nullable = false, length = 50)
    private String category;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Book> books;

}
