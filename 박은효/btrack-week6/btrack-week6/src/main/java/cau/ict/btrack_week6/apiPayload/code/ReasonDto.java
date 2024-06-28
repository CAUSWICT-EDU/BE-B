package cau.ict.btrack_week6.apiPayload.code;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReasonDto {
    private String message;
    private String code;
    private boolean isSuccess;
    private HttpStatus httpStatus;
}
