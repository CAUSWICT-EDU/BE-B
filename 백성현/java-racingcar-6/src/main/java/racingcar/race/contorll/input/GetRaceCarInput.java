package racingcar.race.contorll.input;

import java.util.List;

public class GetRaceCarInput {
    private String carName;  // 레이싱카 이름
    private List<String> cars;  // 레이싱카 리스트
    private int countTry;  // 시도 횟수

    // 기본 생성자
    public GetRaceCarInput() {
    }

    public GetRaceCarInput(String carName) {
        cars.add(carName);
    }


    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public List<String> getCars() {
        return cars;
    }

    public void setCars(List<String> cars) {
        this.cars = cars;
    }

    public int getCountTry() {
        return countTry;
    }

    public void setCountTry(int countTry) {
        this.countTry = countTry;
    }
}
