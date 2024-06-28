package board.board.domain.base;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@MappedSuperclass
public class DateEntity {
    @Column(updatable = false)
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    @PrePersist
    public void prePersist(){
        LocalDateTime now = LocalDateTime.now();
        created_at = now;
        updated_at = now;
    }
    @PreUpdate
    public void preUpdate() {
        updated_at = LocalDateTime.now();
    }
}
