package racingcar.controll;

import racingcar.model.Car;
import racingcar.util.RandomMove;
import racingcar.view.OutputView;

import java.util.List;
import java.util.stream.Collectors;

public class Race {
    private final List<Car> cars;
    private final int attemptCount;

    public Race(List<String> carNames, int attemptCount) {
        this.cars = carNames.stream().map(Car::new).collect(Collectors.toList());
        this.attemptCount = attemptCount;
    }

    public void start() {
        for (int i = 0; i < attemptCount; i++) {
            raceTurn();
            OutputView.printRaceProgress(cars);
        }
        OutputView.printWinners(cars);
    }

    private void raceTurn() {
        for (Car car : cars) {
            int randomValue = RandomMove.getRandomNumber();
            car.move(randomValue);
        }
    }
}
