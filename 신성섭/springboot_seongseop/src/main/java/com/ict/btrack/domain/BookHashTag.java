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
public class BookHashTag extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    private Book book;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id")
    private HashTag hashTag;

    //연관관계 편의 메소드
    public void setBookAndHashTag(Book book, HashTag hashTag) {
        addBookHashTagForBook(book);
        addBookHashTagForHashTag(hashTag);
        setBook(book);
        setHashTag(hashTag);
    }

    private void addBookHashTagForBook(Book book) {
        if(!book.getBookHashTags().contains(this)){
            book.getBookHashTags().add(this);
        }
    }

    private void addBookHashTagForHashTag(HashTag hashTag) {
        if(!hashTag.getBookHashTags().contains(this)){
            hashTag.getBookHashTags().add(this);
        }
    }

    private void setBook(Book book) {
        this.book = book;
    }

    private void setHashTag(HashTag hashTag) {
        this.hashTag = hashTag;
    }

}
