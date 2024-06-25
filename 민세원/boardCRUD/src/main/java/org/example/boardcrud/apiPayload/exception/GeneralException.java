package org.example.boardcrud.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.boardcrud.apiPayload.code.BaseErrorCode;
import org.example.boardcrud.apiPayload.code.ErrorReasonDto;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDto getErrorReasonDTO() {
        return this.code.getReason();
    }

    public ErrorReasonDto getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }

}
