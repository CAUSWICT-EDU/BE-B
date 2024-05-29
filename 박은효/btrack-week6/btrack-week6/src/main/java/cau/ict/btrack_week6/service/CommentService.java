package cau.ict.btrack_week6.service;

import cau.ict.btrack_week6.entity.Comment;
import cau.ict.btrack_week6.repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final CommentRepository commentRepository;

    public List<Comment> findAllCommentByPost(Long postId) {
        return commentRepository.findAllByPostId(postId);
    }
}
