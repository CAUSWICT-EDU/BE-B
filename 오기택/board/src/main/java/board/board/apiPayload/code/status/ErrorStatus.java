package board.board.apiPayload.code.status;

import board.board.apiPayload.code.BaseErrorCode;
import board.board.apiPayload.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorStatus implements BaseErrorCode {

    // 가장 일반적인 응답
    _INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON500", "서버 에러, 관리자에게 문의 바랍니다."),
    _BAD_REQUEST(HttpStatus.BAD_REQUEST,"COMMON400","잘못된 요청입니다."),
    _UNAUTHORIZED(HttpStatus.UNAUTHORIZED,"COMMON401","인증이 필요합니다."),
    _FORBIDDEN(HttpStatus.FORBIDDEN, "COMMON403", "금지된 요청입니다."),

    // 멤버 관련 응답
    MEMBER_NOT_FOUND(HttpStatus.NOT_FOUND, "MEMBER404", "멤버를 찾을 수 없습니다."),
    MEMBER_DUPLICATE(HttpStatus.CONFLICT, "MEMBER409", "이미 존재하는 멤버입니다."),
    MEMBER_UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "MEMBER401", "멤버 인증이 되지 않았습니다."),

    // 게시글 관련 응답
    BOARD_NOT_FOUND(HttpStatus.NOT_FOUND, "BOARD404", "게시글을 찾을 수 없습니다."),
    BOARD_BAD_REQUEST_TITLE(HttpStatus.BAD_REQUEST, "BOARD4000", "게시글 제목이 없습니다."),
    BOARD_BAD_REQUEST_DESCRIPTION(HttpStatus.BAD_REQUEST, "BOARD4001", "게시글 설명이 없습니다."),
    ;

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ErrorReasonDto getReason() {
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .build();
    }

    @Override
    public ErrorReasonDto getReasonHttpStatus() {
        return ErrorReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(false)
                .httpStatus(httpStatus)
                .build();
    }
}