package cau.ict.btrack.exception;

import cau.ict.btrack.util.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class BaseException extends RuntimeException{

    private final ResponseCode responseCode;

    @Override
    public String getMessage() {
        return responseCode.getMessage();
    }
}
