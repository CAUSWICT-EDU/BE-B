package dongne_be.week11.like.entity;

import com.dongne.week11.book.entity.BookEntity;
import com.dongne.week11.member.entity.MemberEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class LikeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private BookEntity book;

    @ManyToOne
    private MemberEntity member;

    private LocalDateTime createdAt;
}
