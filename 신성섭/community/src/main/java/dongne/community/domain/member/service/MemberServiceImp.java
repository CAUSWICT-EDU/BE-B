package dongne.community.domain.member.service;

import dongne.community.domain.member.domain.Member;
import dongne.community.domain.member.domain.repository.MemberRepository;
import dongne.community.domain.member.dto.request.LoginRequestDto;
import dongne.community.domain.member.dto.request.RegisterRequestDto;
import dongne.community.domain.member.dto.request.nickNameUpdateRequestDto;
import dongne.community.domain.member.dto.response.MemberResponseDto;
import dongne.community.global.apipayload.code.status.ErrorStatus;
import dongne.community.global.exception.handler.MemberExceptionHandler;
import dongne.community.global.util.converter.MemberConverter;
import dongne.community.global.util.validator.EntityValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class MemberServiceImp implements MemberService {

    private final MemberRepository memberRepository;
    private final EntityValidator entityValidator;

    @Override
    @Transactional(readOnly = true)
    public MemberResponseDto login(LoginRequestDto loginDto) {
        Member member = entityValidator.validateMember(loginDto.getSignId());

        //비밀번호 불일치인 경우
        if (!member.getPassword().equals(loginDto.getPassword())) {
            throw new MemberExceptionHandler(ErrorStatus.MEMBER_INCORRECT_PW);
        }

        return MemberConverter.toMemberResponseDto(member);
    }

    @Override
    public MemberResponseDto register(RegisterRequestDto registerDto) {
        Optional<Member> existingMember = memberRepository.findBySignId(registerDto.getSignId());

        if (existingMember.isPresent()) {
            throw new MemberExceptionHandler(ErrorStatus.MEMBER_ALREADY_EXISTS);
        }

        Member newMember = MemberConverter.toMember(registerDto);
        memberRepository.save(newMember);

        return MemberConverter.toMemberResponseDto(newMember);

    }

    @Override
    public MemberResponseDto updateMemberInfo(nickNameUpdateRequestDto nickNameUpdateDto) {
        Member member = entityValidator.validateMember(nickNameUpdateDto.getSignId());

        member.setNickName(nickNameUpdateDto.getNickName());
        memberRepository.save(member);

        return MemberConverter.toMemberResponseDto(member);
    }

}
