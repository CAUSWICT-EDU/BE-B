package dongne.community.domain.member.service;

import dongne.community.domain.member.dto.request.LoginRequestDto;
import dongne.community.domain.member.dto.request.RegisterRequestDto;
import dongne.community.domain.member.dto.response.MemberResponseDto;
import jakarta.transaction.Transactional;

public interface MemberService {

    public MemberResponseDto login(LoginRequestDto loginDto);

    public MemberResponseDto register(RegisterRequestDto registerDto);

}
