package org.example.boardcrud.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.boardcrud.apiPayload.code.status.ErrorStatus;

public class ResponseAuth {

    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    public static class MemberDto {
        private String email;
        private String name;
    }

    public static class ExceptionDto {

    }
}
