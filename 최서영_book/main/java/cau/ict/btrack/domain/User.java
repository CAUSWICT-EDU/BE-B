package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.enums.Gender;
import cau.ict.btrack.domain.mapping.Rental;
import cau.ict.btrack.domain.mapping.Likes;
import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=10,nullable=false)
    private String name;

    @Column(length=20,nullable=false)
    private String nickname;

    @Column(length=15)
    private String phoneNum;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 20, nullable = false, unique = true)
    private String loginId;

    @Column(length = 60, nullable = false)
    private String password;

    @Column
    private Boolean isDeleted;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Likes> likes = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Rental> rental = new ArrayList<>();
}
