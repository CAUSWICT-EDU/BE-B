package cau.ict.btrack.domain;

import cau.ict.btrack.domain.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class NotifySetting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean setAnnouncement;

    private Boolean setMarketing;

    private Boolean setBookReturn;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "notify_setting")
    private List<Announcement> announcementList = new ArrayList<>();

    @OneToMany(mappedBy = "notify_setting")
    private List<Marketing> marketingList = new ArrayList<>();

}
