package racingcar.race.raceCar;


import racingcar.race.raceMain.RaceState;

import java.util.Map;

public interface RaceCarService {

    // 자동차 이름 등록
    RaceCar saveCarName(String name);

    RaceCar saveCarInfo(String name, RaceState state);

    RaceCar saveTotalCount(int total_count);

    void saveCurrentState(RaceCar car, RaceState state);

    void getMaxValue(Map<RaceCar, Integer> winnerCar, Map<String, RaceCar> carMap, String[] cars);
}
