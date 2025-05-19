package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.enums.Gender;
import cau.ict.btrack.domain.enums.Status;
import cau.ict.btrack.domain.mapping.Rent;
import cau.ict.btrack.domain.mapping.bookLikes;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
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

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Column(nullable = false, length = 15)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private Status status;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Rent> rentList = new ArrayList<>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<bookLikes> bookLikesList = new ArrayList<>();

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private notifySetting notifySetting;

}
