package book.domain;

import jakarta.persistence.*;
import lombok.*;
import book.domain.base.BaseEntity;

import java.time.LocalDateTime;

@Getter
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor

public class Rent extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "real_book_id", nullable = false)
    private RealBook realBook;

    @Column(nullable = true)
    private LocalDateTime returnedAt;
}