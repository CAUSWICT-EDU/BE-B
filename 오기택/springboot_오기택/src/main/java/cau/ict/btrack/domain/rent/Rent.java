package cau.ict.btrack.domain.rent;

import cau.ict.btrack.domain.alarm.RentAlarm;
import cau.ict.btrack.domain.book.Book;
import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.member.Member;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Rent extends BaseEntity {
    @Column(nullable = false)
    private LocalDateTime rentStart;

    @Column(nullable = false)
    private LocalDateTime rentReturn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @OneToOne
    private RentAlarm rentAlarm;
}