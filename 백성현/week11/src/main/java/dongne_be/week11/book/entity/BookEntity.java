package dongne_be.week11.book.entity;


import dongne_be.week11.bookCategory.entity.BookCategoryEntity;
import dongne_be.week11.hashtag.entity.HashtagEntity;
import dongne_be.week11.like.entity.LikeEntity;
import dongne_be.week11.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @ManyToOne
    private MemberEntity memberEntity;

    @ManyToOne
    private BookCategoryEntity bookCategoryEntity;

    @OneToMany(mappedBy = "book")
    private List<LikeEntity> likes;

    @ManyToMany
    private List<HashtagEntity> hashtags;
}
