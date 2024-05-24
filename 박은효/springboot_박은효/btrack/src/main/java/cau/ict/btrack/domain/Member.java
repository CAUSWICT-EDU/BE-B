package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.enums.Gender;
import cau.ict.btrack.domain.enums.Status;
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
public class Member extends BaseEntity {

    @Id
    private String phone_num;

    @Column(nullable = false, length = 10)
    private String name;

    @Column(nullable = false, length = 20)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(15) DEFAULT 'ACTIVE'")
    private Status status;

    private LocalDate inactiveDate;

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Alarm> alarmList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Rent> rentList = new ArrayList<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<BookLikes> bookLikesList = new ArrayList<>();

}
