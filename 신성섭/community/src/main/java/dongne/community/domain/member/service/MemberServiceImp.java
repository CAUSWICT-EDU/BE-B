package dongne.community.domain.member.service;

import dongne.community.domain.member.domain.Member;
import dongne.community.domain.member.domain.repository.MemberRepository;
import dongne.community.domain.member.dto.request.LoginRequestDto;
import dongne.community.domain.member.dto.request.RegisterRequestDto;
import dongne.community.domain.member.dto.response.MemberResponseDto;
import dongne.community.global.apipayload.code.status.ErrorStatus;
import dongne.community.global.exception.handler.MemberExceptionHandler;
import dongne.community.global.util.converter.MemberConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberServiceImp implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDto login(LoginRequestDto loginDto) {
        Member member = memberRepository.findBySignId(loginDto.getSignId())
                .orElseThrow(() -> new MemberExceptionHandler(ErrorStatus.MEMBER_NOT_FOUND));

        //비밀번호 불일치인 경우
        if (!member.getPassword().equals(loginDto.getPassword())) {
            throw new MemberExceptionHandler(ErrorStatus.MEMBER_INCORRECT_PW);
        }

        return MemberConverter.toMemberResponseDto(member);
    }

    @Override
    public MemberResponseDto register(RegisterRequestDto registerDto) {


        return null;
    }

}
