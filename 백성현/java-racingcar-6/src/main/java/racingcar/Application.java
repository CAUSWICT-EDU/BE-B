package racingcar;

import racingcar.race.contorll.input.GetRaceCarInputService;
import racingcar.race.contorll.input.GetRaceCarInputServiceImpl;
import racingcar.race.contorll.print.PrintResultService;
import racingcar.race.contorll.print.PrintResultServiceImpl;
import racingcar.race.raceCar.RaceCar;
import racingcar.race.raceCar.RaceCarService;
import racingcar.race.raceCar.RaceCarServiceImpl;

import java.util.*;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RaceCarService raceCarService = new RaceCarServiceImpl();
        GetRaceCarInputService getRaceCarInputService = new GetRaceCarInputServiceImpl();
        PrintResultService printResultService = new PrintResultServiceImpl();


        // 레이싱카 이름 입력받기
        String[] cars = getRaceCarInputService.getCarInput();

        // 진행 횟수 입력
        int tryCount = getRaceCarInputService.getTryCount();


        Map<String, RaceCar> carMap = new HashMap<>();

        // Map에 저장
        for (String car : cars) {
            carMap.put(car, new RaceCar(car));
        }


        // Race 현황 출력
        printResultService.printRaceProgress(carMap, cars, tryCount);


        Map<RaceCar, Integer> winnerCar = new HashMap<>();

        raceCarService.getMaxValue(winnerCar, carMap, cars);

        printResultService.printResult(winnerCar);
    }
}
