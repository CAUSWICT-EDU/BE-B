package org.example.boardcrud.apiPayload.code;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
public class ErrorReasonDto {
    private String message;

    private String code;

    private boolean isSuccess;

    private HttpStatus httpStatus;
}
