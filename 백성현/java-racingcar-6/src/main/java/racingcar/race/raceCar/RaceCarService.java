package racingcar.race.raceCar;


import racingcar.race.raceMain.RaceState;

public interface RaceCarService {

    // 자동차 이름 등록
    RaceCar saveCarName(String name);

    RaceCar saveCarInfo(String name, RaceState state);

    RaceCar saveTotalCount(int total_count);

    void savaCurrentState(RaceCar car, RaceState state);
}
