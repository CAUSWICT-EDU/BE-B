package cau.ict.btrack_week6.controller;

import cau.ict.btrack_week6.apiPayload.ApiResponse;
import cau.ict.btrack_week6.dto.MemberResponse;
import cau.ict.btrack_week6.entity.Comment;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    private Member getMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return (Member) session.getAttribute("member");
    }

    @PostMapping("/comment/create")
    public ApiResponse<MemberResponse> create(String body, HttpServletRequest request) {
        Member member = getMember(request);
        commentService.createComment(body, member);
    }

    @GetMapping("/comment/find/all/member")
    public List<Comment> findAll(HttpServletRequest request) {
        Member member = getMember(request);
        return commentService.findAllByMember(member.getId());
    }

    @GetMapping("/commen/find/one/id/{id}")
    public Comment findOneById(@RequestParam(name = "id") Long id) {
        return commentService.readOneById(id);
    }

}
