package dongne.community.domain.post.controller;

import dongne.community.domain.post.dto.request.PostCreateRequestDto;
import dongne.community.domain.post.dto.request.PostDeleteRequestDto;
import dongne.community.domain.post.dto.request.PostUpdateRequestDto;
import dongne.community.domain.post.dto.response.SimplePostResponseDto;
import dongne.community.domain.post.dto.response.PostInfoResponseDto;
import dongne.community.domain.post.service.PostService;
import dongne.community.global.apipayload.ApiResponse;
import dongne.community.global.apipayload.code.status.SuccessStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    // 게시글 작성
    @PostMapping("/new")
    public ApiResponse<SimplePostResponseDto> createPost(
            @Valid @RequestBody PostCreateRequestDto postCreateRequestDto
    ) {
        SimplePostResponseDto simplePost = postService.createPost(postCreateRequestDto);
        return ApiResponse.of(SuccessStatus.POST_OK, simplePost);
    }

    // 게시글 조회
    @GetMapping("/{postId}")
    public ApiResponse<PostInfoResponseDto> findPost(
            @PathVariable Long postId
    ) {
        PostInfoResponseDto postInfo = postService.findPost(postId);
        return ApiResponse.of(SuccessStatus.POST_OK, postInfo);
    }

    // 게시글 수정
    @PutMapping("/{postId}")
    public ApiResponse<SimplePostResponseDto> updatePost(
            @Valid @RequestBody PostUpdateRequestDto postUpdateRequestDto,
            @PathVariable Long postId
    ) {
        SimplePostResponseDto SimplePost = postService.updatePost(postUpdateRequestDto, postId);
        return ApiResponse.of(SuccessStatus.POST_OK, SimplePost);
    }

    // 게시글 삭제
    @DeleteMapping("/{postId}")
    public ApiResponse<Object> deletePost(
            @Valid @RequestBody PostDeleteRequestDto postDeleteRequestDto,
            @PathVariable Long postId
    ) {
        postService.deletePost(postDeleteRequestDto,postId);
        return ApiResponse.of(SuccessStatus.POST_OK, null);
    }

}