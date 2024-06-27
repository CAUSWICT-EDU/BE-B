package dongne.community.global.util.converter;

import dongne.community.domain.member.domain.Member;
import dongne.community.domain.member.dto.request.RegisterRequestDto;
import dongne.community.domain.member.dto.response.MemberResponseDto;

public class MemberConverter {

    public static Member toMember(RegisterRequestDto registerDto) {

            return Member.builder()
                    .signId(registerDto.getSignId())
                    .password(registerDto.getPassword())
                    .nickName(registerDto.getNickName())
                    .build();
    }

    public static MemberResponseDto toMemberResponseDto(Member member) {

        return MemberResponseDto.builder()
                .signID(member.getSignId())
                .NickName(member.getNickName())
                .build();
    }

}
