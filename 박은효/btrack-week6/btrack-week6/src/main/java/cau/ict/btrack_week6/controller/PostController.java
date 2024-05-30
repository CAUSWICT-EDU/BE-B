package cau.ict.btrack_week6.controller;

import cau.ict.btrack_week6.dto.NewPostDto;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.entity.Post;
import cau.ict.btrack_week6.service.PostService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/post/create")
    public Post create(String title, String body, HttpServletRequest request) {
        HttpSession session = request.getSession();
        Member member = (Member) session.getAttribute("member");
        Long postId = postService.createPost(title, body, member);
        return postService.readOneById(postId);
    }

    @GetMapping("/post/find/one/title/{title}")
    public Post findOneByTitle(@RequestParam(name = "title") String title) {

    }

    @GetMapping("/post/find/one/member")
    public Post
}
