package org.example.boardcrud.apiPayload.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.boardcrud.apiPayload.code.BaseErrorCode;
import org.example.boardcrud.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReasonDTO() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus() {
        return this.code.getReasonHttpStatus();
    }

}
