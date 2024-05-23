package com.ict.btrack.domain;


import com.ict.btrack.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class HashTag extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, length = 50)
    private String name ;

    @OneToMany(mappedBy = "hashTag",cascade = CascadeType.ALL)
    private List<BookHashTag> BookHashTags = new ArrayList<>();

}
