package racingcar;
import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars() { cars = new ArrayList<>(); }
    public Cars(List<Car> cars) { this.cars = cars; }

    public Cars(String[] carNames) {
        this.cars = new ArrayList<>();
        for (String carName : carNames) {
            Validator.carNameValidator(carName);
            cars.add(new Car(carName.trim()));
        }
    }

    public List<Car> getCars() {
        return cars;
    }

    public void printInfo() {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
    }

    public List<String> getWinners() {
        int maxPosition = 0;

        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        return winners;
    }
}
