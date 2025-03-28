package racingcar;

import racingcar.race.raceCar.RaceCar;
import racingcar.race.raceCar.RaceCarService;
import racingcar.race.raceCar.RaceCarServiceImpl;
import racingcar.race.raceMain.RaceService;
import racingcar.race.raceMain.RaceServiceImpl;
import racingcar.race.raceMain.RaceState;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RaceService raceService = new RaceServiceImpl();
        RaceCarService raceCarService = new RaceCarServiceImpl();


        Scanner car_scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        String car_input = car_scanner.nextLine();  // 입력받은 자동차 이름
        String[] cars = car_input.split(",");

        System.out.print("횟수를 입력하세요: ");
        Scanner N_canner = new Scanner(System.in);
        int N = N_canner.nextInt(); // 진행 횟수 입력


        for (int i = 0; i < N; i++) {

            for (String car : cars) {

                RaceState currState = raceService.getState();  // GO or STAY
                System.out.println("현재 State: " + currState);

                RaceCar input_car = raceCarService.saveCarInfo(car, currState);  // 이름, GO or STAY 입력

                if (input_car.getState().equals(RaceState.GO)) {
                    input_car.setCount(input_car.getCount() + 1);
                }

                System.out.println(input_car.getCar_name() + " count : " + input_car.getCount());
                for (int j = 0; j < input_car.getCount(); j++) {
                    input_car.getBar().append("-");
                }

                System.out.println(input_car.getCar_name() + ": " + input_car.getBar());
            }

            System.out.println("\n------------------\n");


        }



    }
}
