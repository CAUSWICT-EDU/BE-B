package board.board.apiPayload.exception.handler;

import board.board.apiPayload.code.BaseErrorCode;
import board.board.apiPayload.exception.GeneralException;

public class PostHandler extends GeneralException {
    public PostHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}