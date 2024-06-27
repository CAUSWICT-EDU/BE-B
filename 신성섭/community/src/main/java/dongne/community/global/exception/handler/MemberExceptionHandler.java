package dongne.community.global.exception.handler;

import dongne.community.global.apipayload.code.BaseErrorCode;
import dongne.community.global.exception.GeneralException;

public class MemberExceptionHandler extends GeneralException {
    public MemberExceptionHandler(BaseErrorCode baseErrorCode){
        super(baseErrorCode);
    }
}