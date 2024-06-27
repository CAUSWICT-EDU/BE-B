package dongne.community.global.util.validator;


import dongne.community.domain.member.domain.Member;
import dongne.community.domain.member.domain.enums.Role;
import dongne.community.domain.member.domain.repository.MemberRepository;
import dongne.community.domain.post.domain.Post;
import dongne.community.domain.post.domain.repository.PostRepository;
import dongne.community.global.apipayload.code.status.ErrorStatus;
import dongne.community.global.exception.handler.MemberExceptionHandler;
import dongne.community.global.exception.handler.PostExceptionHandler;
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

    public Post validatePost(Long postId){
        return postRepository.findById(postId)
                .orElseThrow(() -> new PostExceptionHandler(ErrorStatus.POST_NOT_FOUND));
    }

    public void isWriterOfPost(Member member, Post post){
        if(!member.getRole().equals(Role.ADMIN) &&
           !member.getSignId().equals(post.getMember().getSignId())
        ){
            new PostExceptionHandler(ErrorStatus.POST_EDIT_NOT_ALLOWED);
        }
    }

}
