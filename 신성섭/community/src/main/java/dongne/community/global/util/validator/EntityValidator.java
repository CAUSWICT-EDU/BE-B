package dongne.community.global.util.validator;


import dongne.community.domain.member.domain.Member;
import dongne.community.domain.member.domain.repository.MemberRepository;
import dongne.community.domain.post.domain.repository.PostRepository;
import dongne.community.global.apipayload.code.status.ErrorStatus;
import dongne.community.global.exception.handler.MemberExceptionHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EntityValidator {
    private final MemberRepository memberRepository;
    private final PostRepository postRepository;

    public Member validateMember(String signId){
        return memberRepository.findBySignId(signId)
                .orElseThrow(() -> new MemberExceptionHandler(ErrorStatus.MEMBER_NOT_FOUND));
    }



}
