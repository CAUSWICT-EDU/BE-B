package board.board.domain;

import board.board.domain.base.DateEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends DateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(length = 50, name = "member_name", nullable = false)
    private String name;

    @Column(length = 50, unique = true, nullable = false, name = "member_email")
    private String email;

    @Column(length = 50, name = "member_password", nullable = false)
    private String password;

}
