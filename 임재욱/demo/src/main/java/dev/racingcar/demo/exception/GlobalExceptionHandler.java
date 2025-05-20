package dev.racingcar.demo.exception;

import org.springframework.stereotype.Component;

@Component
public class GlobalExceptionHandler {

    public void handle(Exception e) {

        if (e instanceof IllegalArgumentException) {
            System.err.println("[ERROR] 잘못된 입력입니다: " + e.getMessage());
        } else {
            System.err.println("[ERROR] 예기치 못한 오류가 발생했습니다: " + e.getMessage());
        }

    }
}
