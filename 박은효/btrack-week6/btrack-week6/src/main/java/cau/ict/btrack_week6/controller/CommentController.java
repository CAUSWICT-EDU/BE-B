package cau.ict.btrack_week6.controller;

import cau.ict.btrack_week6.apiPayload.ApiResponse;
import cau.ict.btrack_week6.apiPayload.code.status.SuccessStatus;
import cau.ict.btrack_week6.converter.MemberConverter;
import cau.ict.btrack_week6.dto.CommentDto;
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

    private ApiResponse<MemberResponse.MemberDto> getMember(HttpServletRequest request) {
        HttpSession session = request.getSession();
        return ApiResponse.of(SuccessStatus.COMMENT_READ_SUCCESS, MemberResponse.MemberDto.of((Member) session.getAttribute("member")));
    }

    @PostMapping("/comment/create")
    public ApiResponse<CommentDto> create(String body, HttpServletRequest request) {
        Member member = MemberConverter.toMember(getMember(request).getResult());
        return ApiResponse.of(SuccessStatus.COMMENT_CREATE_SUCCESS, commentService.createComment(body, member));
    }

    @GetMapping("/comment/find/all/member")
    public List<Comment> findAll(HttpServletRequest request) {
        Member member = MemberConverter.toMember(getMember(request).getResult());
        return commentService.findAllByMember(member.getId());
    }

    @GetMapping("/commen/find/one/id/{id}")
    public ApiResponse<CommentDto> findOneById(@RequestParam(name = "id") Long id) {
        return ApiResponse.of(SuccessStatus.COMMENT_READ_SUCCESS, CommentDto.of(commentService.readOneById(id)));
    }

}
