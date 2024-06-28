package cau.ict.btrack_week6.converter;

import cau.ict.btrack_week6.dto.MemberResponse;
import cau.ict.btrack_week6.entity.Member;

public class MemberConverter {
    public static Member toMember(MemberResponse.MemberDto memberDto) {
        return Member.builder()
                .name(memberDto.getName())
                .password(memberDto.getPassword())
                .build();
    }
}
