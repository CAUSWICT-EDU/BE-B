package board.board.service;

import board.board.converter.MemberConverter;
import board.board.domain.Member;
import board.board.dto.member.MemberRequest;
import board.board.dto.member.MemberResponse;
import board.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public MemberResponse.MemberDto join(MemberRequest.JoinDto joinDto){
        if(memberRepository.existsMemberByEmail(joinDto.getEmail())){
            return null;
        }

        Member member = MemberConverter.JoinDtoToMember(joinDto);
        memberRepository.save(member);

        return MemberConverter.MemberToMemberDto(member);
    }

    @Transactional
    public MemberResponse.MemberDto login(MemberRequest.LoginDto loginDto){
        Member member = memberRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new Error());
        if (!member.getPassword().equals(loginDto.getPassword())) {
            throw new Error();
        }

        return MemberConverter.MemberToMemberDto(member);
    }
}
