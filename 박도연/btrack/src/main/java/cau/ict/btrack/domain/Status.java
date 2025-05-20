package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import lombok.*;
import jakarta.persistence.*;
import cau.ict.btrack.domain.enums.UserStatus;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Status extends BaseEntity {

    @Id
    private Integer userID;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_iD")
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserStatus status;
}