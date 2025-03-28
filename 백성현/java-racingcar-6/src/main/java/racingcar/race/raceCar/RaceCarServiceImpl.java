package racingcar.race.raceCar;

import racingcar.race.raceMain.RaceState;

public class RaceCarServiceImpl implements RaceCarService {


    // 사용자에게 차량 이름만 입력받기
    @Override
    public RaceCar saveCarName(String car_name) {
        return new RaceCar(car_name);
    }


    @Override
    public RaceCar saveCarInfo(String car_name, RaceState state) {
        return new RaceCar(car_name, state);
    }

    @Override
    public RaceCar saveTotalCount(int total_count) {
        return null;
    }
}