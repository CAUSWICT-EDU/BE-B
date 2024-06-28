package board.board.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

public class PostResponse {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class PostDto{
        private Long postId;
        private String name;
        private String email;
        private String title;
        private String content;
        private LocalDateTime created_at;
        private LocalDateTime updated_at;
    }
}
