package org.example.boardcrud.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.boardcrud.domain.base.BaseEntity;

@Entity
@Table(name = "post")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Post extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "post_id")
    private Long id;

    @Column(nullable = false, length = 300, name = "title")
    private String title;

    @Column(nullable = false, columnDefinition = "TEXT", name = "content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    public void changeTitleAndContent(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
