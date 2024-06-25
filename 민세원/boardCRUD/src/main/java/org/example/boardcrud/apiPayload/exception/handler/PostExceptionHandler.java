package org.example.boardcrud.apiPayload.exception.handler;

import org.example.boardcrud.apiPayload.code.BaseErrorCode;
import org.example.boardcrud.apiPayload.exception.GeneralException;

public class PostExceptionHandler extends GeneralException {
    public PostExceptionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
