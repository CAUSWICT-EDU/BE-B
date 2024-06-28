package org.example.boardcrud.controller;

import lombok.RequiredArgsConstructor;
import org.example.boardcrud.apiPayload.ApiResponse;
import org.example.boardcrud.apiPayload.code.status.SuccessStatus;
import org.example.boardcrud.dto.auth.RequestAuth;
import org.example.boardcrud.dto.auth.ResponseAuth;
import org.example.boardcrud.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;
    // 회원가입
    @PostMapping("/register")
    public ApiResponse<ResponseAuth.MemberDto> register(
            @RequestBody RequestAuth.RegisterDto registerDto
    ) {
        ResponseAuth.MemberDto memberDto = authService.register(registerDto);
        return ApiResponse.of(SuccessStatus._CREATED, memberDto);
    }

    // 로그인
    @PostMapping("/login")
    public ApiResponse<ResponseAuth.MemberDto> login(
            @RequestBody RequestAuth.LoginDto loginDto
    ) {
        ResponseAuth.MemberDto memberDto = authService.login(loginDto);
        return ApiResponse.of(SuccessStatus._OK, memberDto);
    }

}
