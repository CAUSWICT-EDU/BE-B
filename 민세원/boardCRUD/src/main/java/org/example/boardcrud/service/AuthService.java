package org.example.boardcrud.service;

import lombok.RequiredArgsConstructor;
import org.example.boardcrud.apiPayload.code.status.ErrorStatus;
import org.example.boardcrud.apiPayload.exception.handler.AuthExceptionHandler;
import org.example.boardcrud.converter.AuthConverter;
import org.example.boardcrud.domain.Member;
import org.example.boardcrud.dto.auth.RequestAuth;
import org.example.boardcrud.dto.auth.ResponseAuth;
import org.example.boardcrud.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final MemberRepository memberRepository;

    @Transactional
    public ResponseAuth.MemberDto register(RequestAuth.RegisterDto registerDto) {
        if (memberRepository.existsByEmail(registerDto.getEmail())) {
            throw new AuthExceptionHandler(ErrorStatus.MEMBER_ALREADY_EXIST);
        }

        Member newMember = AuthConverter.registerDtoToEntity(registerDto);
        memberRepository.save(newMember);

        return AuthConverter.entityToResponseMemberDto(newMember);
    }

    @Transactional
    public ResponseAuth.MemberDto login(RequestAuth.LoginDto loginDto) {
        Member member = memberRepository.findByEmail(loginDto.getEmail())
                .orElseThrow(() -> new AuthExceptionHandler(ErrorStatus.MEMBER_NOT_FOUND));

        if (!member.getPassword().equals(loginDto.getPassword())) {
            throw new AuthExceptionHandler(ErrorStatus.MEMBER_FORBIDDEN);
        }

        return AuthConverter.entityToResponseMemberDto(member);
    }

}







