package umc.study.domain;

import jakarta.persistence.*;
import lombok.*;
import umc.study.domain.base.BaseEntity;

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

    private long id;
    private String name;

    @OneToMany(mappedBy = "bookhashtag", cascade = CascadeType.ALL)
    private List<BookHashTag> bookhashTag = new ArrayList<>();
}
