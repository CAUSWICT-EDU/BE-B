package org.example.boardcrud.converter;

import org.example.boardcrud.domain.Member;
import org.example.boardcrud.domain.Post;
import org.example.boardcrud.dto.post.RequestPost;
import org.example.boardcrud.dto.post.ResponsePost;
import org.springframework.data.domain.Page;

import java.util.List;

public class PostConverter {
    public static Post createDtoToPost(RequestPost.CreateDto createDto, Member member) {

        return Post.builder()
                .title(createDto.getTitle())
                .content(createDto.getContent())
                .member(member)
                .build();
    }

    public static List<ResponsePost.InfoDto> postsToInfoDto(Page<Post> posts) {

        return posts.stream().map((post) -> ResponsePost.InfoDto.builder()
                .postId(post.getId())
                .title(post.getTitle())
                .writer(post.getMember().getName())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build()
        ).toList();
    }

    public static ResponsePost.DetailInfoDto postToDetailInfoDto(Post post) {

        return ResponsePost.DetailInfoDto.builder()
                .title(post.getTitle())
                .content(post.getContent())
                .writer(post.getMember().getName())
                .writerEmail(post.getMember().getEmail())
                .createdAt(post.getCreatedAt())
                .updatedAt(post.getUpdatedAt())
                .build();
    }
}
