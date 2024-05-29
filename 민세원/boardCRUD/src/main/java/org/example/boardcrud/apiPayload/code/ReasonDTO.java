package org.example.boardcrud.apiPayload.code;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class ReasonDTO {
    private String message;

    private int code; // 성공한 경우는 int로 받음

    private boolean isSuccess;

    private HttpStatus httpStatus;
}
