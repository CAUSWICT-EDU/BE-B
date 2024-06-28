package cau.ict.btrack_week6.converter;

import cau.ict.btrack_week6.dto.PostResponse;
import cau.ict.btrack_week6.entity.Post;

public class PostConverter {
    public static Post toPost(PostResponse.NewPostDto newPostDto) {
        return Post.builder()
                .title(newPostDto.getTitle())
                .body(newPostDto.getBody())
                .build();
    }
}
