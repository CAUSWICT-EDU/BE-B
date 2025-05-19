package com.example.demo.domain;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import com.example.demo.domain.common.BaseTimeEntity;

@Entity
public class Notification extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    private String type;

    @Lob
    private String content;

    private LocalDateTime readAt;
}
