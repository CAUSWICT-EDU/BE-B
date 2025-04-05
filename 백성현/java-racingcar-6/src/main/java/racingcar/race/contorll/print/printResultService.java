package racingcar.race.contorll.print;

import racingcar.race.raceCar.RaceCar;

import java.util.Map;

public interface printResultService {

    void printRaceProgress(Map<String, RaceCar> carMap, String[] cars, int tryCount);


    void printResult(Map<RaceCar, Integer> winnerCar);

}
