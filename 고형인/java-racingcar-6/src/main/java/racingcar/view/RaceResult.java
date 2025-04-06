package racingcar.view;

import racingcar.car.Car;
import racingcar.race.Race;

import java.util.List;

public class RaceResult {
    public static void printWinners(Race race) {
        List<Car> winners = race.getWinners();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getCarName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }

    public static void printCarPosition(Car car) {
        String carName = car.getCarName();
        int carDistance = car.getDistance();

        System.out.print(carName + " : ");
        for (int i=0;i<carDistance;i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}
