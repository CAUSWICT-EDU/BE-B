package org.example.boardcrud.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.boardcrud.apiPayload.code.BaseCode;
import org.example.boardcrud.apiPayload.code.ReasonDTO;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    // 인증, 인가 관련 응답
    _OK(HttpStatus.OK, 200, "로그인이 성공하였습니다."),
    _CREATED(HttpStatus.CREATED, 201, "회원가입이 성공하였습니다."),

    // 게시물 관련 응답
    POST_CREATED(HttpStatus.CREATED, 201, "게시글 작성이 성공하였습니다."),
    POST_UPDATED(HttpStatus.OK, 200, "게시글 수정이 성공하였습니다."),
    POST_DELETED(HttpStatus.OK, 200, "게시글 삭제가 성공하였습니다."),
    POST_GET(HttpStatus.OK, 200, "게시글 조회가 성공하였습니다."),
    ;

    private final HttpStatus httpStatus;

    private final int code;

    private String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(this.message)
                .code(this.code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(this.message)
                .code(this.code)
                .isSuccess(true)
                .httpStatus(this.httpStatus)
                .build();
    }
}
