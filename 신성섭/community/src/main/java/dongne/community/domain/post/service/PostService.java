package dongne.community.domain.post.service;

import dongne.community.domain.post.dto.request.PostCreateRequestDto;
import dongne.community.domain.post.dto.request.PostDeleteRequestDto;
import dongne.community.domain.post.dto.request.PostUpdateRequestDto;
import dongne.community.domain.post.dto.response.PostInfoResponseDto;
import dongne.community.domain.post.dto.response.SimplePostResponseDto;

public interface PostService {

    public SimplePostResponseDto createPost(PostCreateRequestDto createDto);

    public PostInfoResponseDto findPost(Long postId);

    public SimplePostResponseDto updatePost(PostUpdateRequestDto postUpdateRequestDto, Long postId);

    public void deletePost(PostDeleteRequestDto deleteRequestDto, Long postId);

}
