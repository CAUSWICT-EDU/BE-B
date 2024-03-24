package racingcar.Entity;

import racingcar.Interface.CarInterface;
import racingcar.Interface.WinnerInterface;

import java.util.ArrayList;
import java.util.List;

public class Winner implements WinnerInterface {
    @Override
    public List<String> setWinner(List<CarInterface> cars) {
        List<String> winners = new ArrayList<>();
        int max = cars.get(0).getLocation();

        for (CarInterface car : cars) {
            if (car.getLocation() > max) {
                max = car.getLocation();
            }
        }

        for (CarInterface car : cars) {
            if (max == car.getLocation()) {
                winners.add(car.getName());
            }
        }

        return winners;
    }
}
