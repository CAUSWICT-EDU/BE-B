package dongne.community.domain.member.domain.repository;

import dongne.community.domain.member.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findBySignId(String signId);
}
