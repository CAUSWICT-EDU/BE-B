package cau.ict.btrack_week6.repository;

import cau.ict.btrack_week6.dto.PostDto;
import cau.ict.btrack_week6.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByTitle(String postTitle);

    Optional<Post> findByMemberId(Long id);
}
