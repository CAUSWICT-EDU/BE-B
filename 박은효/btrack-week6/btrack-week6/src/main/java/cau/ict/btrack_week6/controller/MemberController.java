package cau.ict.btrack_week6.controller;

import cau.ict.btrack_week6.apiPayload.ApiResponse;
import cau.ict.btrack_week6.apiPayload.code.status.SuccessStatus;
import cau.ict.btrack_week6.converter.MemberConverter;
import cau.ict.btrack_week6.dto.MemberResponse;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.service.MemberService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @Operation(summary = "회원가입 API", description = "새로운 사용자를 등록합니다.")
    @PostMapping("/member/new")
    public ApiResponse<MemberResponse.MemberDto> join(String name, String password) {
        MemberResponse.MemberDto memberDto = new MemberResponse.MemberDto(name, password);
        Member member = MemberConverter.toMember(memberDto);
        return ApiResponse.of(SuccessStatus.MEMBER_JOIN_SUCCESS, memberService.join(member));
    }
}
