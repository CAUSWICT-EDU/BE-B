package com.example.demo.domain.mapping;

import com.example.demo.domain.Member;
import jakarta.persistence.*;
import com.example.demo.domain.common.BaseTimeEntity;

@Entity
public class Block extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Member owner;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private Member target;
}
