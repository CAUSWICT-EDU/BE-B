package cau.ict.btrack_week6.dto;

import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.entity.Post;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberResponse {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberDto{
        private String name;
        private String password;

        public static MemberDto of(Member member) {
            return new MemberDto(member.getName(), member.getPassword());
        }
    }

}
