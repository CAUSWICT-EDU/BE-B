package cau.ict.btrack_week6.converter;

import cau.ict.btrack_week6.dto.CommentDto;
import cau.ict.btrack_week6.entity.Comment;

public class CommentConverter {
    public static Comment toComment(CommentDto commentDto) {
        return Comment.builder()
                .body(commentDto.getBody())
                .member(commentDto.getMember())
                .build();
    }
}
