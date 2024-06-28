package board.board.controller;


import board.board.apiPayload.ApiResponse;
import board.board.apiPayload.code.status.SuccessStatus;
import board.board.dto.member.MemberRequest;
import board.board.dto.member.MemberResponse;
import board.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/member")
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/join")
    public ApiResponse<MemberResponse.MemberDto> join(@RequestBody MemberRequest.JoinDto joinDto){
        MemberResponse.MemberDto memberDto = memberService.join(joinDto);
        return ApiResponse.of(SuccessStatus.MEMBER_CREATED,memberDto);
    }

    @PostMapping("/login")
    public ApiResponse<MemberResponse.MemberDto> login(@RequestBody MemberRequest.LoginDto loginDto){
        MemberResponse.MemberDto memberDto = memberService.login(loginDto);
        return ApiResponse.of(SuccessStatus._OK,memberDto);
    }
}
