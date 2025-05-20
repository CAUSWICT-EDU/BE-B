package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookHashTag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hash_Tag_id")
    private HashTag hashTag;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private  Book book;
}
