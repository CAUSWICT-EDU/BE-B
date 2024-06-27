package dongne.community.global.util.converter;

import dongne.community.domain.member.domain.Member;
import dongne.community.domain.member.dto.response.MemberResponseDto;
import dongne.community.domain.post.domain.Post;
import dongne.community.domain.post.dto.request.PostCreateRequestDto;
import dongne.community.domain.post.dto.response.PostInfoResponseDto;
import dongne.community.domain.post.dto.response.SimplePostResponseDto;

public class PostConverter {

    public static Post toPost(PostCreateRequestDto createDto, Member member){
        return Post.builder()
                .title(createDto.getTitle())
                .content(createDto.getContent())
                .member(member)
                .build();
    }

    public static SimplePostResponseDto toSimplePostResponseDto(Post post){
        return SimplePostResponseDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .build();
    }

    public static PostInfoResponseDto toPostInfoResponseDto(Post post) {
        MemberResponseDto memberResponseDto = MemberConverter.toMemberResponseDto(post.getMember());

        return PostInfoResponseDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .content(post.getContent())
                .lastUpdateTime(post.getUpdatedAt())
                .member(memberResponseDto)
                .build();
    }

}
