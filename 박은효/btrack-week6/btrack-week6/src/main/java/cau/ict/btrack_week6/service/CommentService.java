package cau.ict.btrack_week6.service;

import cau.ict.btrack_week6.apiPayload.code.BaseErrorCode;
import cau.ict.btrack_week6.apiPayload.code.status.ErrorStatus;
import cau.ict.btrack_week6.apiPayload.exception.GeneralException;
import cau.ict.btrack_week6.converter.CommentConverter;
import cau.ict.btrack_week6.dto.CommentDto;
import cau.ict.btrack_week6.entity.Comment;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public CommentDto createComment(String body, Member member) {
        CommentDto commentDto = new CommentDto(body, member);
        Comment comment = CommentConverter.toComment(commentDto);
        commentRepository.save(comment);
        return commentDto;
    }

    public Comment readOneById(Long id) {
        Optional<Comment> comment = commentRepository.findById(id);
        return comment.orElseThrow(() -> new GeneralException(ErrorStatus.COMMENT_NOT_FOUND));
    }

    public List<Comment> findAllByMember(Long memberId) {
        return commentRepository.findAllByMemberId(memberId);
    }
}
