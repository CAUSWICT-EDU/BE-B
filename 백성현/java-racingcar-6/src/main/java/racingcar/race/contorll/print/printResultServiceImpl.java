package racingcar.race.contorll.print;

import racingcar.race.raceCar.RaceCar;
import racingcar.race.raceCar.RaceCarService;
import racingcar.race.raceCar.RaceCarServiceImpl;
import racingcar.race.raceMain.RaceService;
import racingcar.race.raceMain.RaceServiceImpl;
import racingcar.race.raceMain.RaceState;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class printResultServiceImpl implements printResultService {
    RaceService raceService = new RaceServiceImpl();
    RaceCarService raceCarService = new RaceCarServiceImpl();


    @Override
    public void printRaceProgress(Map<String, RaceCar> carMap, String[] cars, int tryCount) {
        System.out.println("실행결과\n");
        for (int i = 0; i < tryCount; i++) {

            for (String car : cars) {

                RaceState currState = raceService.getState();  // GO or STAY

                //  RaceCar inputCar = raceCarService.saveCarInfo(car, currState);  // 이름, GO or STAY 입력
                // => for문마다 객체가 새로 생성돼서 count가 누적되지 않음

                RaceCar inputCar = carMap.get(car);

                raceCarService.saveCurrentState(inputCar, currState);

                if (inputCar.getState().equals(RaceState.GO)) {
                    inputCar.setCount(inputCar.getCount() + 1);
                    inputCar.getBar().append("-");  // GO이면 바로 "-" 추가 => 아래 문제 해결
                }

                //  "-"가 중복적으로 추가되었던 이유
//              for (int j = 0; j < inputCar.getCount(); j++) {
//                  inputCar.getBar().append("-");
//              }


                System.out.println(inputCar.getCar_name() + ": " + inputCar.getBar());
            }

            System.out.println("\n------------------------------------------\n");
        }
    }




    @Override
    public void printResult(Map<RaceCar, Integer> winnerCar) {

        // 깔끔하게 출력하기
        System.out.print("우승자: ");
        List<String> carNames = new ArrayList<>();
        for (RaceCar car : winnerCar.keySet()) {
            carNames.add(car.getCar_name());
        }

        System.out.println(String.join(", ", carNames));


        // 우승자 출력
//        System.out.print("우승자: ");
//        for (RaceCar car : winnerCar.keySet()) {
//            System.out.print(car.getCar_name() + " ");
//        }

        // stream 이용하기!!
//        System.out.print("우승자: ");
//        System.out.println(
//                winnerCar.keySet().stream()
//                        .map(RaceCar::getCar_name)
//                        .collect(Collectors.joining(", "))
//        );
    }
}
