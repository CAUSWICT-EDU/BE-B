package cau.ict.btrack.domain.member;

import cau.ict.btrack.domain.alarm.Alarm;
import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.enums.*;
import cau.ict.btrack.domain.like.Likes;
import cau.ict.btrack.domain.rent.Rent;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
public class Member extends BaseEntity {
    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 255)
    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MemberStatus status;

    @Column
    private LocalDateTime inactivateDate;

    @OneToMany(mappedBy = "member" , cascade = CascadeType.ALL)
    private List<Rent> rents;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Alarm> alarms;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Likes> likes;
}
