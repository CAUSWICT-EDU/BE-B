package cau.ict.btrack_week6.dto;

import cau.ict.btrack_week6.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private String title;
    private String body;

    public static PostDto of(Post post) {
        return new PostDto(post.getTitle(), post.getBody());
    }
}
