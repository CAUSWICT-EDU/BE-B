package dongne.community.domain.member.domain;

import dongne.community.domain.member.domain.enums.MemberStatus;
import dongne.community.domain.member.domain.enums.Role;
import dongne.community.domain.post.domain.Post;
import dongne.community.global.domain.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;
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

    @Column(length = 30 , nullable = false, unique = true)
    private String signId;

    @Column(length = 30, nullable = false)
    private String password;

    @Column(length = 20, nullable = false, unique = true)
    private String nickName;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'USER'")
    private Role role;

    @Enumerated(EnumType.STRING)
    @ColumnDefault("'ACTIVE'")
    private MemberStatus status;

    @OneToMany(mappedBy = "member")
    private List<Post> writtenPosts = new ArrayList<>();

}
