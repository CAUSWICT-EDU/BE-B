package cau.ict.btrack_week6.controller;

import cau.ict.btrack_week6.apiPayload.ApiResponse;
import cau.ict.btrack_week6.apiPayload.code.status.SuccessStatus;
import cau.ict.btrack_week6.converter.MemberConverter;
import cau.ict.btrack_week6.dto.MemberResponse;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/member/new")
    public ApiResponse<MemberResponse.MemberDto> join(String name, String password) {
        MemberResponse.MemberDto memberDto = new MemberResponse.MemberDto(name, password);
        Member member = MemberConverter.toMember(memberDto);
        return ApiResponse.of(SuccessStatus.MEMBER_JOIN_SUCCESS, memberService.join(member));
    }
}
