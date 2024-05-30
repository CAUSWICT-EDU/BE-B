package cau.ict.btrack_week6.service;

import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public void join(Member member) { //회원가입 메소드에서 반환형을 void로 할지, Long으로 해서 가입된 멤버의 id를 반환하게 할지 고민입니다..!
        memberRepository.save(member);
//        return member.getId();
    }
}
