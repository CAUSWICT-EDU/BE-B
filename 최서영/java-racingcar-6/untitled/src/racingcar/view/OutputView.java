package racingcar.view;

import racingcar.model.Car;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public static void printRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getProgress());
        }
        System.out.println();
    }

    public static void printWinners(List<Car> cars) {
        int maxPosition = cars.stream().mapToInt(Car::getPosition).max().orElse(0); // 만약 자동차가 하나도 없을 시 오류를 방지하는 0으로 예외처리
        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.println("최종 우승자 : " + String.join(", ", winners)); // 우승자 여러명 출력 가능
    }
}
