package book.domain;

import jakarta.persistence.*;
import lombok.*;
import book.domain.base.BaseEntity;
import book.domain.enums.Gender;
import book.domain.enums.Status;

import java.util.List;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 10)
    private String name;
    @Column(nullable = false, length = 15)
    private String nickname;
    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Gender gender;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(10)")
    private Status status;

    @Column(nullable = false, length = 20)
    private String loginId;
    @Column(nullable = false, length = 256)
    private String password;

    @OneToMany(mappedBy = "member")
    private List<Rent> rents;


}
