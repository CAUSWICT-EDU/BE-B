package cau.ict.btrack_week6.apiPayload.exception.handler;

import cau.ict.btrack_week6.apiPayload.code.BaseErrorCode;
import cau.ict.btrack_week6.apiPayload.exception.GeneralException;

public class TempHandler extends GeneralException {
    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
