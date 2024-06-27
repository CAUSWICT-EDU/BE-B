package dongne.community.domain.post.service;

import dongne.community.domain.member.domain.Member;
import dongne.community.domain.member.domain.repository.MemberRepository;
import dongne.community.domain.post.domain.Post;
import dongne.community.domain.post.domain.repository.PostRepository;
import dongne.community.domain.post.dto.request.PostCreateRequestDto;
import dongne.community.domain.post.dto.request.PostDeleteRequestDto;
import dongne.community.domain.post.dto.request.PostUpdateRequestDto;
import dongne.community.domain.post.dto.response.SimplePostResponseDto;
import dongne.community.domain.post.dto.response.PostInfoResponseDto;
import dongne.community.global.util.converter.PostConverter;
import dongne.community.global.util.validator.EntityValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class PostServiceImp implements  PostService{

    private final MemberRepository memberRepository;
    private final PostRepository postRepository;
    private final EntityValidator entityValidator;

    public SimplePostResponseDto createPost(PostCreateRequestDto createDto) {
        Member member = entityValidator.validateMember(createDto.getSignId());

        Post newPost = PostConverter.toPost(createDto, member);
        member.addPost(newPost);
        newPost = postRepository.save(newPost);

        return PostConverter.toSimplePostResponseDto(newPost);
    }

    @Transactional(readOnly = true)
    public PostInfoResponseDto findPost(Long postId) {
        Post post = entityValidator.validatePost(postId);

        return PostConverter.toPostInfoResponseDto(post);
    }

    public SimplePostResponseDto updatePost(PostUpdateRequestDto postUpdateRequestDto, Long postId) {
        Post post = entityValidator.validatePost(postId);
        Member member = entityValidator.validateMember(postUpdateRequestDto.getSignId());
        entityValidator.isWriterOfPost(member,post);

        post.changeTitleAndContent(postUpdateRequestDto.getTitle(), postUpdateRequestDto.getContent());
        postRepository.save(post);

        return PostConverter.toSimplePostResponseDto(post);
    }

    public void deletePost(PostDeleteRequestDto deleteRequestDto, Long postId) {
        Post post = entityValidator.validatePost(postId);
        Member member = entityValidator.validateMember(deleteRequestDto.getSignId());
        entityValidator.isWriterOfPost(member,post);

        post.setIsDeleted(true);
        postRepository.save(post);
    }
}
