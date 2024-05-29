package org.example.boardcrud.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.boardcrud.apiPayload.code.BaseErrorCode;
import org.example.boardcrud.apiPayload.code.ErrorReasonDTO;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {
    // 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 내부 에러"),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST, "COMMON400", "잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "COMMON401", "인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "권한이 없습니다."),

    // 멤버 관련 에러
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404", "해당 회원을 찾을 수 없습니다."),
    NAME_NOT_EXIST(HttpStatus.BAD_REQUEST, "NAME400", "이름을 입력해주세요."),

    // 게시글 관련 에러
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "POST404", "해당 게시글을 찾을 수 없습니다."),
    ;


    private final HttpStatus httpStatus;

    private final String code;

    private final String message;

    @Override
    public ErrorReasonDTO getReason() {
        return ErrorReasonDTO.builder()
                .message(this.message)
                .code(this.code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDTO getReasonHttpStatus() {
        return ErrorReasonDTO.builder()
                .message(this.message)
                .code(this.code)
                .isSuccess(false)
                .httpStatus(this.httpStatus)
                .build();
    }
}
