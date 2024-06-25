package cau.ict.btrack_week6.controller;

import cau.ict.btrack_week6.dto.NewPostDto;
import cau.ict.btrack_week6.dto.PostDto;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.entity.Post;
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
    public PostDto create(String title, String body, HttpServletRequest request) {
        Member member = getMember(request);
        Long postId = postService.createPost(title, body, member);
        return postService.readOneById(postId);
    }

    @GetMapping("/find/one/title/{title}")
    public PostDto findOneByTitle(@PathVariable String title) {
        return postService.readOneByTitle(title);
    }

    @GetMapping("/find/all/member")
    public List<PostDto> findAllByMember(HttpServletRequest request) {
        Member member = getMember(request);
        return postService.readAllByMember(member);
    }

    @GetMapping("/find/all")
    public List<PostDto> findAll() {
        return postService.readAll();
    }

    @PostMapping("/update")
    public void update(Long id, @RequestBody PostDto postDto) {
        postService.updatePost(id, postDto.getTitle(), postDto.getBody());
    }

}
