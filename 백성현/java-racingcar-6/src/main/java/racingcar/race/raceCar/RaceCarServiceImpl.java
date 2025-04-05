package racingcar.race.raceCar;

import racingcar.race.raceMain.RaceState;

import java.util.Arrays;
import java.util.Map;

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

    @Override
    public void saveCurrentState(RaceCar car, RaceState state) {
        car.setState(state);
    }


    @Override
    public void getMaxValue(Map<RaceCar, Integer> winnerCar, Map<String, RaceCar> carMap, String[] cars) {
        int[] countValue = new int[cars.length];
        int carIdx = 0;

        // count 값을 count_val에 넣기
        for (RaceCar car : carMap.values()) {
            countValue[carIdx] = car.getCount();
            carIdx++;
        }

        // count_val에서 최대 count 찾기
        int max = Arrays.stream(countValue).max().getAsInt();

        for (RaceCar car : carMap.values()) {
            if (car.getCount() == max) {
                winnerCar.put(car, carIdx);
            }
        }
    }
}