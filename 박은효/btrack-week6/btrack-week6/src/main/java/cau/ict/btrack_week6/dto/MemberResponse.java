package cau.ict.btrack_week6.dto;

import cau.ict.btrack_week6.entity.Member;
import cau.ict.btrack_week6.entity.Post;
import io.swagger.v3.oas.annotations.media.Schema;
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
        @Schema(description = "사용자 이름", example = "홍길동")
        private String name;

        @Schema(description = "사용자 비밀번호", example = "1234")
        private String password;

        public static MemberDto of(Member member) {
            return new MemberDto(member.getName(), member.getPassword());
        }
    }

}
