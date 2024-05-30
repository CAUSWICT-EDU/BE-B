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
@RequestMapping("/api")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    private Member getMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Member) session.getAttribute("member");
    }

    @PostMapping("/post/create")
    public Post create(String title, String body, HttpServletRequest request) {
        Member member = getMember(request);
        Long postId = postService.createPost(title, body, member);
        return postService.readOneById(postId);
    }

    @GetMapping("/post/find/one/title/{title}")
    public PostDto findOneByTitle(@RequestParam(name = "title") String title) {
        return postService.readOneByTitle(title);
    }

    @GetMapping("/post/find/all/member")
    public List<PostDto> findAllByMember(HttpServletRequest request) {
        Member member = getMember(request);
        return postService.readAllByMember(member);
    }



}
