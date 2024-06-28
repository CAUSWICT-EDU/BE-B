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

@RestController()
@RequestMapping("/api/posts")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    // 게시글 작성
    @PostMapping()
    public ApiResponse<ResponsePost.DetailInfoDto> createPost(
            @RequestBody RequestPost.CreateDto createDto
    ) {
        return ApiResponse.of(SuccessStatus.POST_CREATED, postService.createPost(createDto));
    }

    // 게시글 목록 조회
    // GET /api/posts?page=0&size=10&sort=createdAt,desc
    @GetMapping()
    public ApiResponse<List<ResponsePost.InfoDto>> getPosts(
            Pageable pageable
    ) {
        return ApiResponse.of(SuccessStatus.POST_GET_LIST, postService.getPosts(pageable));

    }

    // 게시글 수정
    @PutMapping("/{postId}")
    public ApiResponse<ResponsePost.DetailInfoDto> editPost(
            @RequestBody RequestPost.EditDto editDto,
            @PathVariable Long postId
    ) {
        return ApiResponse.of(SuccessStatus.POST_UPDATED, postService.editPost(editDto, postId));
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
        return ApiResponse.of(SuccessStatus.POST_GET_DETAIL, postService.getPostDetail(postId));
    }

}
