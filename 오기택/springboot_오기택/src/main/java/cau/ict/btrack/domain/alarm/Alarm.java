package cau.ict.btrack.domain.alarm;

import cau.ict.btrack.domain.common.BaseEntity;
import jakarta.persistence.*;

import java.util.List;
import cau.ict.btrack.domain.member.Member;

@Entity
public class Alarm extends BaseEntity {
    @Column(nullable = false, length = 255)
    private String title;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToMany(mappedBy = "alarm" , cascade = CascadeType.ALL)
    private List<RentAlarm> rentAlarms;

    @OneToMany(mappedBy = "alarm" , cascade = CascadeType.ALL)
    private List<Marketing> marketings;

    @OneToMany(mappedBy = "alarm" , cascade = CascadeType.ALL)
    private List<Notice> notices;
}