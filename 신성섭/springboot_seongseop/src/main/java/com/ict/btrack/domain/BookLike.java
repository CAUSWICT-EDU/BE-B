package com.ict.btrack.domain;

import com.ict.btrack.domain.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.*;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class BookLike extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    //양방향 편의 메소드
    public void setBookAndMember(Book book, Member member) {
        addBookLikeForBook(book);
        addBookLikeForMember(member);
        setBook(book);
        setMember(member);
    }

    private void addBookLikeForBook(Book book){
        if(!book.getBookLikes().contains(this)){
            book.getBookLikes().add(this);
        }
    }

    private void addBookLikeForMember(Member member){
        if(!member.getBookLikes().contains(this)){
            book.getBookLikes().add(this);
        }
    }

    private void setBook(Book book){
        this.book = book;
    }

    private void setMember(Member member){
        this.member = member;
    }
}


