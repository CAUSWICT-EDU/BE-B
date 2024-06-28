package board.board.converter;

import board.board.domain.Member;
import board.board.domain.Post;
import board.board.dto.post.PostRequest;
import board.board.dto.post.PostResponse;

public class PostConverter {
    public static Post CreateDtoToPost(PostRequest.CreateDto createDto, Member member){
        return Post.builder()
                .title(createDto.getTitle())
                .content(createDto.getContent())
                .member(member)
                .build();
    }

    public static PostResponse.PostDto PostToPostDto(Post post){
        return PostResponse.PostDto.builder()
                .postId(post.getId())
                .name(post.getMember().getName())
                .email(post.getMember().getEmail())
                .title(post.getTitle())
                .content(post.getContent())
                .created_at(post.getCreated_at())
                .updated_at(post.getUpdated_at())
                .build();
    }
}
