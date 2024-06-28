package board.board.dto.member;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class MemberRequest {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class JoinDto{
        private String name;
        private String email;
        private String password;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginDto{
        private String email;
        private String password;
    }
}
