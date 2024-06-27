package dongne.community.global.exception.handler;

import dongne.community.global.apipayload.code.BaseErrorCode;
import dongne.community.global.exception.GeneralException;

public class PostExceptionHandler extends GeneralException {
    public PostExceptionHandler(BaseErrorCode baseErrorCode){
        super(baseErrorCode);
    }
}
