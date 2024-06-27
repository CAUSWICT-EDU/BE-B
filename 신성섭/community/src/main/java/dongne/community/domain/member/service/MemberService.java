package dongne.community.domain.member.service;

import dongne.community.domain.member.dto.request.LoginRequestDto;
import dongne.community.domain.member.dto.request.RegisterRequestDto;
import dongne.community.domain.member.dto.request.NickNameUpdateRequestDto;
import dongne.community.domain.member.dto.response.MemberResponseDto;

public interface MemberService {

    public MemberResponseDto login(LoginRequestDto loginDto);

    public MemberResponseDto register(RegisterRequestDto registerDto);

    public MemberResponseDto updateMemberInfo(NickNameUpdateRequestDto nickNameUpdateDto);

}
