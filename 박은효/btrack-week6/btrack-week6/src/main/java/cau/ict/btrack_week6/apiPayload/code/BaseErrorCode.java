package cau.ict.btrack_week6.apiPayload.code;

public interface BaseErrorCode {
    ErrorReasonDto getReason();

    ErrorReasonDto getReasonHttpStatus();
}
