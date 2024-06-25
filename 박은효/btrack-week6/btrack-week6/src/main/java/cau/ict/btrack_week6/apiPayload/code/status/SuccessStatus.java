package cau.ict.btrack_week6.apiPayload.code.status;

import cau.ict.btrack_week6.apiPayload.code.BaseCode;
import cau.ict.btrack_week6.apiPayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    //멤버 관련 성공
    MEMBER_JOIN_SUCCESS(HttpStatus.CREATED, "JOIN2001", "회원가입 성공"),

    //게시글, 댓글 관련 성공
    POST_CREATE_SUCCESS(HttpStatus.CREATED, "CREATE2001", "게시글 작성 성공"),
    POST_READ_SUCCESS(HttpStatus.OK, "READ2000", "게시글 조회 성공"),
    POST_UPDATE_SUCCESS(HttpStatus.OK, "UPDATE2000", "게시글 수정 성공"),
    POST_DELETE_SUCCESS(HttpStatus.OK, "DELETE2000", "게시글 삭제 성공"),

    COMMENT_CREATE_SUCCESS(HttpStatus.CREATED, "CREATE2001", "게시글 작성 성공"),
    COMMENT_READ_SUCCESS(HttpStatus.OK, "READ2000", "게시글 조회 성공"),
    COMMENT_UPDATE_SUCCESS(HttpStatus.OK, "UPDATE2000", "게시글 수정 성공"),
    COMMENT_DELETE_SUCCESS(HttpStatus.OK, "DELETE2000", "게시글 삭제 성공");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .code(code)
                .message(message)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDto getReasonHttpStatus() {
        return ReasonDto.builder()
                .code(code)
                .message(message)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}
