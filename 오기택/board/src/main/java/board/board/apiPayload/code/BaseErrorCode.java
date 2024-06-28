package board.board.apiPayload.code;

public interface BaseErrorCode {

    public ErrorReasonDto getReason();

    public ErrorReasonDto getReasonHttpStatus();
}