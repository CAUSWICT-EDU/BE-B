package com.ict.btrack.domain;

import com.ict.btrack.domain.common.BaseEntity;
import com.ict.btrack.domain.enums.Gender;
import com.ict.btrack.domain.enums.UserStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Member extends BaseEntity {

    @Column(nullable = false, length = 25)
    private String name;

    @Column(columnDefinition = "VARCHAR(25) DEFAULT 'GUEST'")
    private String nickName;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(length = 255)
    private String address;

    @Column(nullable = false, length = 15)
    private String phoneNumber;

    @Enumerated(EnumType.STRING)
    private UserStatus userStatus = UserStatus.ACTIVE;

    private LocalDateTime inactiveDate;

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<Rent> rents = new ArrayList<>();

    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
    private List<BookLike> BookLikes = new ArrayList<>();


}
