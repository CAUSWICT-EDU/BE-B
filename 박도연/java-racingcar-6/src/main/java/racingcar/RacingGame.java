package racingcar;

import java.util.ArrayList;

public class RacingGame{
    private RacingGame() {};

    public static void playGame(Cars cars, int count, MovingStrategy strategy) {
        for (int i = 0; i < count; i++) {
            for(Car car : cars.getCars()) {
                car.strategyMove(strategy);
            }
            cars.printInfo();
        }
    }
}
