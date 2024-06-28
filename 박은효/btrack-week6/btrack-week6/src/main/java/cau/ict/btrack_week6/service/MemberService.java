package cau.ict.btrack_week6.service;

import cau.ict.btrack_week6.converter.MemberConverter;
import cau.ict.btrack_week6.dto.MemberResponse;
import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberResponse.MemberDto join(Member member) {
        memberRepository.save(member);
        return MemberResponse.MemberDto.of(member);
    }
}
