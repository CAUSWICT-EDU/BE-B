package com.ict.btrack.domain;

import com.ict.btrack.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Rent extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @CreatedDate
    private LocalDateTime borrowDate;

    @Column(nullable = false, length = 2)
    private Integer extensionCount = 0;

    //연관 관계 편의 메소드
    public void setBookAndMember(Book book, Member member) {
        addRentForBook(book);
        addRentForMember(member);
        setBook(book);
        setMember(member);
    }

    private void addRentForBook(Book book){
        if(!book.getRents().contains(this)){
            book.getRents().add(this);
        }
    }

    private void addRentForMember(Member member){
        if(!member.getRents().contains(this)){
            member.getRents().add(this);
        }
    }

    private void setBook(Book book) {
        this.book = book;
    }

    private void setMember(Member member){
        this.member = member;
    }

}
