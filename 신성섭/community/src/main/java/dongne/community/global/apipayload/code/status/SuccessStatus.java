package dongne.community.global.apipayload.code.status;

import dongne.community.global.apipayload.code.BaseCode;
import dongne.community.global.apipayload.code.ReasonDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum SuccessStatus implements BaseCode {

    MEMBER_OK(HttpStatus.OK, "MEMBER_2000", "Member 관련 요청이 성공적으로 수행되었습니다."),
    POST_OK(HttpStatus.OK, "POST_2000", "Post 관련 요청이 성공적으로 수행되었습니다.");

    private final HttpStatus httpStatus;
    private final String code;
    private final String message;

    @Override
    public ReasonDTO getReason() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .build();
    }

    @Override
    public ReasonDTO getReasonHttpStatus() {
        return ReasonDTO.builder()
                .message(message)
                .code(code)
                .isSuccess(true)
                .httpStatus(httpStatus)
                .build()
                ;
    }
}
