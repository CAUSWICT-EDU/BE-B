package org.example.boardcrud.converter;

import org.example.boardcrud.domain.Member;
import org.example.boardcrud.dto.auth.RequestAuth;
import org.example.boardcrud.dto.auth.ResponseAuth;

// DTO <-> Entity 변환을 담당함

public class AuthConverter {
    public static Member registerDtoToEntity(RequestAuth.RegisterDto registerDto) {

        return Member.builder()
                .email(registerDto.getEmail())
                .name(registerDto.getName())
                .password(registerDto.getPassword())
                .build();
    }

    public static ResponseAuth.MemberDto entityToResponseMemberDto(Member member) {

        return ResponseAuth.MemberDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }
}

