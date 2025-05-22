package cau.ict.btrack.domain;

import jakarta.persistence.*;
import lombok.*;
import cau.ict.btrack.domain.common.BaseEntity;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class BookCategory extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=20,nullable = false)
    private String name;
}
