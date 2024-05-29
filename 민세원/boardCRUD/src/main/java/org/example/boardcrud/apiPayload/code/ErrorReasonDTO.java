package org.example.boardcrud.apiPayload.code;

import lombok.Builder;
import org.springframework.http.HttpStatus;

@Builder
public class ErrorReasonDTO {
    private String message;

    private String code; // 실패한 경우는 String으로 받음(자세한 사항 표시하기 위해서)

    private boolean isSuccess;

    private HttpStatus httpStatus;
}
