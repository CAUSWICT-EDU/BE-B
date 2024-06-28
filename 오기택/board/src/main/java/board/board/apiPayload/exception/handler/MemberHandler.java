package board.board.apiPayload.exception.handler;

import board.board.apiPayload.code.BaseErrorCode;
import board.board.apiPayload.exception.GeneralException;

public class MemberHandler extends GeneralException {
    public MemberHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
