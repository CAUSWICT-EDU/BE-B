package board.board.apiPayload.code.status;

import board.board.apiPayload.code.BaseCode;
import board.board.apiPayload.code.ReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    // 멤버 관련 응답
    _OK(HttpStatus.OK, "AUTH200", "로그인이 성공하였습니다."),
    MEMBER_CREATED(HttpStatus.CREATED, "MEMBER201", "멤버가 성공적으로 생성되었습니다."),
    MEMBER_UPDATED(HttpStatus.OK, "MEMBER200", "멤버 정보가 성공적으로 업데이트되었습니다."),
    MEMBER_DELETED(HttpStatus.OK, "MEMBER200", "멤버가 성공적으로 삭제되었습니다."),
    MEMBER_FOUND(HttpStatus.OK, "MEMBER200", "멤버가 성공적으로 조회되었습니다."),

    // 게시글 관련 응답
    POST_CREATED(HttpStatus.CREATED, "POST201", "게시글이 성공적으로 생성되었습니다."),
    POST_UPDATED(HttpStatus.OK, "POST200", "게시글이 성공적으로 업데이트되었습니다."),
    POST_DELETED(HttpStatus.OK, "POST200", "게시글이 성공적으로 삭제되었습니다."),
    POST_FOUND(HttpStatus.OK, "POST200", "게시글이 성공적으로 조회되었습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDto getReason() {
        return ReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDto getReasonHttpStatus() {
        return ReasonDto.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build();
    }
}