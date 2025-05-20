package racingcar;

public class Validator {
    final static int MAX_NAME_LENGTH = 5;

    private Validator() {}
    public static int tryCountValidator(String tryCountInput) {
        int tryCount = 0;

        // 1. 빈 입력값 예외 처리
        if (tryCountInput == null || tryCountInput.trim().isEmpty()) {
            throw new IllegalArgumentException("시도 횟수는 비어 있을 수 없습니다.");
        }

        try {
            tryCount = Integer.parseInt(tryCountInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }

        // 양수인지 검증
        if (tryCount <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수여야 합니다.");
        }

        return (tryCount);
    }

    public static void carNameValidator(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }

        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        if (name.contains(",")) {
            throw new IllegalArgumentException("자동차 이름에 ','를 포함할 수 없습니다.");
        }
    }}
