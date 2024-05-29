package cau.ict.btrack_week6.dto;

import cau.ict.btrack_week6.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDto {
    private String body;
    private Member member;
}
