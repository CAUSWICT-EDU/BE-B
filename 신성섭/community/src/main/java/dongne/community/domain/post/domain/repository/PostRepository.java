package dongne.community.domain.post.domain.repository;

import dongne.community.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository  extends JpaRepository<Member, Long> {

}
