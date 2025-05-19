package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import cau.ict.btrack.domain.enums.setNotify;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class notifySetting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(5) DEFAULT 'ON'")
    private setNotify setAnnouncement;

    @Column(columnDefinition = "VARCHAR(5) DEFAULT 'OFF'")
    @Enumerated(EnumType.STRING)
    private setNotify setMarketing;

    @Column(columnDefinition = "VARCHAR(5) DEFAULT 'ON'")
    @Enumerated(EnumType.STRING)
    private setNotify setBookReturn;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "notify_setting", cascade = CascadeType.ALL)
    private List<Announcement> announcementList = new ArrayList<>();

    @OneToMany(mappedBy = "notify_setting", cascade = CascadeType.ALL)
    private List<Marketing> marketingList = new ArrayList<>();

}
