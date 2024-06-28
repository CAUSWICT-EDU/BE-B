package board.board.dto.post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class PostRequest {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateDto{
        private String email;
        private String title;
        private String content;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateDto{
        private Long postId;
        private String title;
        private String content;
    }
}
