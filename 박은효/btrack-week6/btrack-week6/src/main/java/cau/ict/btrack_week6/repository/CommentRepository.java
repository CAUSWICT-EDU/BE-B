package cau.ict.btrack_week6.repository;

import cau.ict.btrack_week6.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAllByMemberId(Long memberId);
}
