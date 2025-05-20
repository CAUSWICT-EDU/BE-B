package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.mapping.BookHasTag;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class HasTag extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=20,nullable = false)
    private String name;

    @OneToMany(mappedBy = "hastag", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BookHasTag> bookHasTags = new ArrayList<>();
}
