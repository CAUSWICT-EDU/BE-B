package cau.ict.btrack_week6.dto;

import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NewPostDto {
    private String title;
    private String body;
    private Member member;

    public static NewPostDto of(Post post) {
        return new NewPostDto(post.getTitle(), post.getBody(), post.getMember());
    }
}
