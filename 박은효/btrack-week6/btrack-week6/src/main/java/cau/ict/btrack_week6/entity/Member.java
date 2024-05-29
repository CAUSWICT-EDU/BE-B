package cau.ict.btrack_week6.entity;

import cau.ict.btrack_week6.entity.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    private String name;

    @Column(nullable = false)
    private String password;

    @OneToMany(mappedBy = "member") //member 객체가 삭제되어도 게시글은 남아 있도록
    private List<Post> postList = new ArrayList<>();

    @OneToMany(mappedBy = "member")
    private List<Comment> commentList = new ArrayList<>();
}
