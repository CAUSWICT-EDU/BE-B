package board.board.controller;

import board.board.apiPayload.ApiResponse;
import board.board.apiPayload.code.status.SuccessStatus;
import board.board.dto.member.MemberRequest;
import board.board.dto.member.MemberResponse;
import board.board.dto.post.PostRequest;
import board.board.dto.post.PostResponse;
import board.board.service.PostService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {
    private final PostService postService;

    @PostMapping("/create")
    public ApiResponse<PostResponse.PostDto> join(@RequestBody PostRequest.CreateDto createDto){
        PostResponse.PostDto postDto = postService.create(createDto);
        return ApiResponse.of(SuccessStatus.POST_CREATED,postDto);
    }

    @PostMapping("/update")
    public ApiResponse<PostResponse.PostDto> update(@RequestBody PostRequest.UpdateDto updateDto){
        PostResponse.PostDto postDto = postService.update(updateDto);
        return ApiResponse.of(SuccessStatus.POST_UPDATED,postDto);
    }

    @GetMapping("/{id}")
    public ApiResponse<PostResponse.PostDto> getPost(@PathVariable Long id){
        PostResponse.PostDto postDto = postService.getPost(id);
        return ApiResponse.of(SuccessStatus.POST_FOUND,postDto);
    }
}
