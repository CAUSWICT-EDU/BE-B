package racingcar;

public class Race {
    private RacingCar[] cars;

    public void setCars(String[] carNames) {
        this.cars = new RacingCar[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            this.cars[i] = new RacingCar(carNames[i]);
        }
    }

    public void doRace(){
        for (RacingCar car : cars) {
            car.race();
        }
    }

    public void printResult() {
        for (RacingCar car : cars) {
            System.out.print(car.getName() + ": ");
            for (int i = 0; i < car.getPosition(); i++) {
                System.out.print("-");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void getWinner() {
        int maxPosition = 0;
        for (RacingCar car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        System.out.print("우승자는 ");
        for (RacingCar car : cars) {
            if (car.getPosition() == maxPosition) {
                System.out.print(car.getName() + " ");
            }
        }
        System.out.println("입니다.");
    }

}
