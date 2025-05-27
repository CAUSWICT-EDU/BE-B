package dongne_be.week11.member.entity;

import com.dongne.week11.like.entity.LikeEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class MemberEntity {

    @Id
    private int id;
    private String phoneNumber;
    private String name;
    private String nickname;
    private String gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime inactiveAt;

    @OneToMany(mappedBy = "member")
    private List<LikeEntity> likes;

}
