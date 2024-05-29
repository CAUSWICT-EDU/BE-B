package cau.ict.btrack_week6.converter;

import cau.ict.btrack_week6.dto.NewPostDto;
import cau.ict.btrack_week6.dto.PostDto;
import cau.ict.btrack_week6.entity.Post;

public class PostConverter {
    public static Post toPost(NewPostDto newPostDto) {
        return Post.builder()
                .title(newPostDto.getTitle())
                .body(newPostDto.getBody())
                .build();
    }
}
