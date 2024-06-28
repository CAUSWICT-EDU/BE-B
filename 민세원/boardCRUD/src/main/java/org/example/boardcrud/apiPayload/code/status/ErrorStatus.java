package org.example.boardcrud.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.boardcrud.apiPayload.code.BaseErrorCode;
import org.example.boardcrud.apiPayload.code.ErrorReasonDto;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 내부 에러"),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON4000", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON4001", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON4003", "권한이 없습니다."),

    // 인증/인가 관련 에러
    MEMBER_ALREADY_EXIST(HttpStatus.BAD_REQUEST, "AUTH4000", "이미 존재하는 회원입니다."),
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "AUTH4004", "존재하지 않는 이메일입니다"),
    MEMBER_FORBIDDEN(HttpStatus.FORBIDDEN, "AUTH4003", "비밀번호가 일치하지 않습니다"),


    // 게시글 관련 에러
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "POST4004", "해당 게시글을 찾을 수 없습니다."),
    ;


    private final HttpStatus httpStatus;

    private final String code;

    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .message(this.message)
                .code(this.code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .message(this.message)
                .code(this.code)
                .isSuccess(false)
                .httpStatus(this.httpStatus)
                .build();
    }
}
