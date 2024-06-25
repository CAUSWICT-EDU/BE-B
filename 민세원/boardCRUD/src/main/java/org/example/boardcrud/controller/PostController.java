package org.example.boardcrud.controller;

import lombok.RequiredArgsConstructor;
import org.example.boardcrud.apiPayload.ApiResponse;
import org.example.boardcrud.apiPayload.code.status.SuccessStatus;
import org.example.boardcrud.dto.post.RequestPost;
import org.example.boardcrud.dto.post.ResponsePost;
import org.example.boardcrud.service.PostService;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 작성
    @PostMapping()
    public ApiResponse<Long> createPost(
            @RequestBody RequestPost.CreateDto createDto
    ) {
        Long postId = postService.createPost(createDto);

        return ApiResponse.of(SuccessStatus.POST_CREATED, postId);
    }

    // 게시글 목록 조회
    // GET /api/posts?page=0&size=10&sort=createdAt,desc
    @GetMapping()
    public ApiResponse<List<ResponsePost.InfoDto>> getPosts(
            Pageable pageable
    ) {
        List<ResponsePost.InfoDto> postInfos = postService.getPosts(pageable);
        return ApiResponse.of(SuccessStatus.POST_GET_LIST, postInfos);

    }

    // 게시글 수정
    @PutMapping("/{postId}")
    public ApiResponse<Long> editPost(
            @RequestBody RequestPost.EditDto editDto,
            @PathVariable Long postId
    ) {
        postService.editPost(editDto, postId);
        return ApiResponse.of(SuccessStatus.POST_UPDATED, postId);
    }

    // 게시글 삭제
    @DeleteMapping("/{postId}")
    public ApiResponse<Object> deletePost(
            @PathVariable Long postId
    ) {
        postService.deletePost(postId);
        return ApiResponse.of(SuccessStatus.POST_DELETED, null);
    }

    // 게시글 조회
    @GetMapping("/{postId}")
    public ApiResponse<ResponsePost.DetailInfoDto> getPostDetail(
            @PathVariable Long postId
    ) {
        ResponsePost.DetailInfoDto postDetail = postService.getPostDetail(postId);
        return ApiResponse.of(SuccessStatus.POST_GET_DETAIL, postDetail);
    }

}
