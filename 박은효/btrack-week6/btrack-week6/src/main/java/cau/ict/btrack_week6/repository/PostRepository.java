package cau.ict.btrack_week6.repository;

import cau.ict.btrack_week6.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {
    Optional<Post> findByTitle(String postTitle);

    Optional<List<Post>> findByMemberId(Long id);
}
