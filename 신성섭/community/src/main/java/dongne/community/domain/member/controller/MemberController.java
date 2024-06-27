package dongne.community.domain.member.controller;

import dongne.community.domain.member.dto.request.LoginRequestDto;
import dongne.community.domain.member.dto.request.NickNameUpdateRequestDto;
import dongne.community.domain.member.dto.request.RegisterRequestDto;
import dongne.community.domain.member.dto.response.MemberResponseDto;
import dongne.community.domain.member.service.MemberService;
import dongne.community.global.apipayload.ApiResponse;
import dongne.community.global.apipayload.code.status.SuccessStatus;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/api")
@RestController
public class MemberController {

    private final MemberService memberService;

    // 로그인
    @PostMapping("/login")
    public ApiResponse<MemberResponseDto> login(
            @Valid @RequestBody LoginRequestDto loginRequestDto
    ) {
        MemberResponseDto memberDto = memberService.login(loginRequestDto);
        return ApiResponse.of(SuccessStatus.MEMBER_OK, memberDto);
    }

    // 회원가입
    @PostMapping("/register")
    public ApiResponse<MemberResponseDto> register(
            @Valid @RequestBody RegisterRequestDto registerRequestDto
    ) {
        MemberResponseDto memberDto = memberService.register(registerRequestDto);
        return ApiResponse.of(SuccessStatus.MEMBER_OK, memberDto);
    }

    // 닉네임 수정
    @PatchMapping("/member/nickname")
    public ApiResponse<MemberResponseDto> updateNickName(
            @Valid @RequestBody NickNameUpdateRequestDto nickNameUpdateRequestDto
    ){
        MemberResponseDto memberDto = memberService.updateMemberInfo(nickNameUpdateRequestDto);
        return ApiResponse.of(SuccessStatus.MEMBER_OK, memberDto);
    }

}
