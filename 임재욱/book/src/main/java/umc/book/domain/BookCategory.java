package umc.book.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.book.domain.base.BaseEntity;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class BookCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 15)
    private String name;

}