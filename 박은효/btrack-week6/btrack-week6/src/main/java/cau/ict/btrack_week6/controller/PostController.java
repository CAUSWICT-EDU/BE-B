package cau.ict.btrack_week6.controller;

import cau.ict.btrack_week6.apiPayload.ApiResponse;
import cau.ict.btrack_week6.apiPayload.code.status.SuccessStatus;
import cau.ict.btrack_week6.dto.PostResponse;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private Member getMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Member) session.getAttribute("member");
    }

    @PostMapping("/create")
    public ApiResponse<PostResponse.NewPostDto> create(String title, String body, HttpServletRequest request) {
        Member member = getMember(request);
        return ApiResponse.of(SuccessStatus.POST_CREATE_SUCCESS, postService.createPost(title, body, member));
    }

    @GetMapping("/find/one/title/{title}")
    public ApiResponse<PostResponse.PostDto> findOneByTitle(@PathVariable String title) {
        return ApiResponse.of(SuccessStatus.POST_READ_SUCCESS, postService.readOneByTitle(title));
    }

    @GetMapping("/find/all/member")
    public ApiResponse<List<PostResponse.PostDto>> findAllByMember(HttpServletRequest request) {
        Member member = getMember(request);
        return ApiResponse.of(SuccessStatus.POST_READ_SUCCESS, postService.readAllByMember(member));
    }

    @GetMapping("/find/all")
    public ApiResponse<List<PostResponse.PostDto>> findAll() {
        return ApiResponse.of(SuccessStatus.POST_READ_SUCCESS, postService.readAll());
    }

    @PostMapping("/update")
    public ApiResponse<PostResponse.PostDto> update(Long id, @RequestBody PostResponse.PostDto postDto) {
        return ApiResponse.of(SuccessStatus.POST_UPDATE_SUCCESS, postService.updatePost(id, postDto.getTitle(), postDto.getBody()));
    }

}
