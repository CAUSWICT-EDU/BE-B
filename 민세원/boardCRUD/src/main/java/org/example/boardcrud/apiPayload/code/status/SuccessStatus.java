package org.example.boardcrud.apiPayload.code.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.boardcrud.apiPayload.code.BaseCode;
import org.example.boardcrud.apiPayload.code.ReasonDto;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {
    // 인증, 인가 관련 응답
    _OK(HttpStatus.OK, "AUTH200", "로그인이 성공하였습니다."),
    _CREATED(HttpStatus.CREATED, "AUTH201", "회원가입이 성공하였습니다."),

    // 게시물 관련 응답
    POST_CREATED(HttpStatus.CREATED, "POST201", "게시글 작성이 성공하였습니다."),
    POST_UPDATED(HttpStatus.OK, "POST200", "게시글 수정이 성공하였습니다."),
    POST_DELETED(HttpStatus.OK, "POST200", "게시글 삭제가 성공하였습니다."),
    POST_GET_LIST(HttpStatus.OK, "POST200", "게시글 목록 조회가 성공하였습니다."),
    POST_GET_DETAIL(HttpStatus.OK, "POST200", "단일 게시글 조회가 성공하였습니다."),
    ;

    private final HttpStatus httpStatus;

    private final String code;

    private final String message;

    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .message(this.message)
                .code(this.code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDto getReasonHttpStatus() {
        return ReasonDto.builder()
                .message(this.message)
                .code(this.code)
                .isSuccess(true)
                .httpStatus(this.httpStatus)
                .build();
    }
}
