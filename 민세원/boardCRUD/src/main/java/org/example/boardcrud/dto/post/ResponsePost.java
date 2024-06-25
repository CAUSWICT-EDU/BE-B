package org.example.boardcrud.dto.post;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

public class ResponsePost {
    @Builder
    @Getter
    @AllArgsConstructor
    public static class InfoDto {
        private final Long postId;
        private String title;
        private String writer;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

    @Builder
    @Getter
    @AllArgsConstructor
    public static class DetailInfoDto {
        private final Long postId;
        private String title;
        private String content;
        private String writer;
        private String writerEmail;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

}
