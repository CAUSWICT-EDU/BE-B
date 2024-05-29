package cau.ict.btrack_week6.apiPayload.exception;

import cau.ict.btrack_week6.apiPayload.code.BaseErrorCode;
import cau.ict.btrack_week6.apiPayload.code.ErrorReasonDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException{

    private BaseErrorCode code;

    public ErrorReasonDto getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDto getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }

    @Override
    public String getMessage() {
        return code.getReason().getMessage();
    }
}
