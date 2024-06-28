package board.board.converter;

import board.board.domain.Member;
import board.board.dto.member.MemberRequest;
import board.board.dto.member.MemberResponse;

public class MemberConverter {
    public static Member JoinDtoToMember(MemberRequest.JoinDto joinDto) {
        return Member.builder()
                .name(joinDto.getName())
                .email(joinDto.getEmail())
                .password(joinDto.getPassword())
                .build();
    }

    public static MemberResponse.MemberDto MemberToMemberDto(Member member) {

        return MemberResponse.MemberDto.builder()
                .email(member.getEmail())
                .name(member.getName())
                .build();
    }
}
