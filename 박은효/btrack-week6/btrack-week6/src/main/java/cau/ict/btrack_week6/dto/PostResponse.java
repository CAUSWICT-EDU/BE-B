package cau.ict.btrack_week6.dto;

import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


public class PostResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class PostDto{
        private String title;
        private String body;

        public static PostDto of(Post post) {
            return new PostResponse.PostDto(post.getTitle(), post.getBody());
        }
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class NewPostDto{
        private String title;
        private String body;
        private Member member;

        public static NewPostDto of(Post post) {
            return new NewPostDto(post.getTitle(), post.getBody(), post.getMember());
        }
    }
}
