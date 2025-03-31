package racingcar;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 자동차 이름 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = sc.nextLine();
        String[] carName = carNames.split(",");
        // 자동차 이름 유효성 검사
        for (String name : carName) {
            if (name.isBlank() || name.strip().length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.");
            }
        }
        racingcar[] cars = new racingcar[carName.length];
        for (int i = 0; i < carName.length; i++) {
            // 자동차 객체 생성
            cars[i] = new racingcar(carName[i].strip());
        }
        System.out.println("시도할 회수는 몇회인가요?");
        int tryCount;
        try {
            tryCount = sc.nextInt();
        }
        catch (InputMismatchException exception) {
            throw new IllegalArgumentException("시도 횟수는 정수여야 합니다.");
        }
        if (tryCount < 1) {
            throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
        }
        // 시도 횟수만큼 자동차 이동
        System.out.println("실행 결과:");
        for (int i = 0; i < tryCount; i++) {
            for (racingcar car : cars) {
                car.race();
            }
            System.out.println();
        }

        // 우승자 출력
        int maxPosition = 0;
        for (racingcar car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }
        System.out.print("최종 우승자: ");
        for (racingcar car : cars) {
            if (car.getPosition() == maxPosition) {
                System.out.print(car.carname + " ");
            }
        }
    }
}
