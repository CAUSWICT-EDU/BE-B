package cau.ict.btrack_week6.dto;

import cau.ict.btrack_week6.entity.Comment;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private String body;
    private Member member;

    public static CommentDto of(Comment comment) {
        return new CommentDto(comment.getBody(), comment.getMember());
    }
}
