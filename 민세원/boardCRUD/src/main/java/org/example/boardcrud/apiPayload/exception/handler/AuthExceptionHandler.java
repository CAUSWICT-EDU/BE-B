package org.example.boardcrud.apiPayload.exception.handler;

import org.example.boardcrud.apiPayload.code.BaseErrorCode;
import org.example.boardcrud.apiPayload.exception.GeneralException;

public class AuthExceptionHandler extends GeneralException {
    public AuthExceptionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

