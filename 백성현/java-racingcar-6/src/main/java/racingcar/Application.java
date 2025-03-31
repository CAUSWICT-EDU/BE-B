package racingcar;

import racingcar.race.raceCar.RaceCar;
import racingcar.race.raceCar.RaceCarService;
import racingcar.race.raceCar.RaceCarServiceImpl;
import racingcar.race.raceMain.RaceService;
import racingcar.race.raceMain.RaceServiceImpl;
import racingcar.race.raceMain.RaceState;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RaceService raceService = new RaceServiceImpl();
        RaceCarService raceCarService = new RaceCarServiceImpl();


        Scanner car_scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String car_input = car_scanner.nextLine();  // 입력받은 자동차 이름
        String[] cars = car_input.split(",");

        System.out.print("시도할 회수는 몇회인가요? ");
        Scanner N_canner = new Scanner(System.in);
        int N = N_canner.nextInt(); // 진행 횟수 입력


        Map<String, RaceCar> carMap = new HashMap<>();

        // Map에 저장
        for (String car : cars) {
            carMap.put(car, new RaceCar(car));
        }

        System.out.println("실행결과\n");
        for (int i = 0; i < N; i++) {

            for (String car : cars) {

                RaceState currState = raceService.getState();  // GO or STAY
//                System.out.println("현재 State: " + currState);

            //  RaceCar input_car = raceCarService.saveCarInfo(car, currState);  // 이름, GO or STAY 입력
            // => for문마다 객체가 새로 생성돼서 count가 누적되지 않음

                RaceCar input_car = carMap.get(car);

                raceCarService.savaCurrentState(input_car, currState);

                if (input_car.getState().equals(RaceState.GO)) {
                    input_car.setCount(input_car.getCount() + 1);
                    input_car.getBar().append("-");  // GO이면 바로 "-" 추가 => 아래 문제 해결
                }

//                System.out.println(input_car.getCar_name() + " count : " + input_car.getCount());

                //  "-"가 중복적으로 추가되었던 이유
//              for (int j = 0; j < input_car.getCount(); j++) {
//                  input_car.getBar().append("-");
//              }


//                System.out.println(input_car.getCar_name() + "의 현재 Bar: " + input_car.getBar());
                System.out.println(input_car.getCar_name() + ": " + input_car.getBar());
            }

            System.out.println("\n------------------------------------------\n");
        }

        Map<RaceCar, Integer> winnerCar = new HashMap<>();

        int[] count_val = new int[cars.length];
        int carIdx = 0;

        // count 값을 count_val에 넣기
        for (RaceCar car : carMap.values()) {
            count_val[carIdx] = car.getCount();
            carIdx++;
        }

        // count_val에서 최대 count 찾기
        int max = Arrays.stream(count_val).max().getAsInt();

        for (RaceCar car : carMap.values()) {
            if (car.getCount() == max) {
                winnerCar.put(car, carIdx);
            }
        }

        // 우승자 출력
//        System.out.print("우승자: ");
//        for (RaceCar car : winnerCar.keySet()) {
//            System.out.print(car.getCar_name() + " ");
//        }

        // 깔끔하게 출력하기!!
        System.out.print("우승자: ");
        List<String> car_names = new ArrayList<>();
        for (RaceCar car : winnerCar.keySet()) {
            car_names.add(car.getCar_name());
        }

        System.out.println(String.join(", ", car_names));

        // stream 이용하기!!
//        System.out.print("우승자: ");
//        System.out.println(
//                winnerCar.keySet().stream()
//                        .map(RaceCar::getCar_name)
//                        .collect(Collectors.joining(", "))
//        );
    }
}
