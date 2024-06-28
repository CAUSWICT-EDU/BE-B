package org.example.boardcrud.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class RequestAuth {
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegisterDto {
        private String email;
        private String password;
        private String name;
    }

    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class LoginDto {
        private String email;
        private String password;
    }

}
