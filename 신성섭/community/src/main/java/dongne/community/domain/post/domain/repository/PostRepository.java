package dongne.community.domain.post.domain.repository;

import dongne.community.domain.member.domain.Member;
import dongne.community.domain.post.domain.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Post, Long> {

}
