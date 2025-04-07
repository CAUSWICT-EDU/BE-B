package racingcar;
import java.util.ArrayList;
import java.util.List;

public class RacingGame{
    private RacingGame() {};

    public static void playGame(Cars cars, int count, MovingStrategy strategy) {
        for (int i = 0; i < count; i++) {
            for(Car car : cars.getCars()) {
                car.strategyMove(strategy);
            }
            cars.printInfo();
            System.out.println();
        }
    }

    public static void printWinners(Cars cars) {
        List<String> winners = cars.getWinners();
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
