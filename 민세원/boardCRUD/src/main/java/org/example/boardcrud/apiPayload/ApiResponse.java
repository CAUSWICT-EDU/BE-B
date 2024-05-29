package org.example.boardcrud.apiPayload;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.boardcrud.apiPayload.code.status.SuccessStatus;

@Getter
@AllArgsConstructor
@JsonPropertyOrder({"isSuccess", "code", "message", "result"})
public class ApiResponse<T> {

    @JsonProperty("isSuccess")
    private final boolean isSuccess;

    private final int code;

    private final String message;

    @JsonInclude(JsonInclude.Include.NON_NULL) // result가 null일 경우 response에 포함하지 않음
    private final T result; // 어떤 값이 올지 모르기 때문에 Generic으로 선언

    public static  <T> ApiResponse<T> onSuccess(T result) { // <T> -> 제네릭 쓸거다 선언...? / ApiResponse<T> -> 리턴 타입
        return new ApiResponse<>(true, SuccessStatus._OK.getCode(), SuccessStatus._OK.getMessage(), result);
    }

    public static <T> ApiResponse<T> onCreated(T result) {
        return new ApiResponse<>(true, SuccessStatus._CREATED.getCode(), SuccessStatus._CREATED.getMessage(), result);

    }

    public static  <T> ApiResponse<T> onFailure(String code, String message, T data) {
        return new ApiResponse<>(false, Integer.parseInt(code), message, data);
    }
}
