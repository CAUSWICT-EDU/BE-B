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
    private setNotify setAnnouncement;

    @Enumerated(EnumType.STRING)
    private setNotify setMarketing;

    @Enumerated(EnumType.STRING)
    private setNotify setBookReturn;

    @OneToMany(mappedBy = "notify_setting", cascade = CascadeType.ALL)
    private List<Announcement> announcementList = new ArrayList<>();

    @OneToMany(mappedBy = "notify_setting", cascade = CascadeType.ALL)
    private List<Marketing> marketingList = new ArrayList<>();

}
