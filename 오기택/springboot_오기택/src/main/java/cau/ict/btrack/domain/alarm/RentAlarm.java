package cau.ict.btrack.domain.alarm;

import jakarta.persistence.*;
@Entity
public class RentAlarm {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private Alarm alarm;
}