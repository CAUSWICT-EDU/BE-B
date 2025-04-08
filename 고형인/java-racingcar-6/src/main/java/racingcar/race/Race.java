package racingcar.race;

import racingcar.car.Car;
import racingcar.view.RaceResult;

import java.util.ArrayList;
import java.util.List;

public class Race {
    private final ArrayList<Car> cars; // 자동차 동적 배열 리스트
    private int maxDistance = 0;

    public Race() {
        this.cars = new ArrayList<>();
        this.maxDistance = 0;
    }

    public Race(String carNames) {
        this.cars = new ArrayList<>(); // 자동차 동적 배열 리스트에 자동차 넣기
        String[] carNameList = carNames.split(",");
        for (String carName : carNameList) {
            Car car = new Car(carName.trim());
            car.checkName(); // 자동차 이름 확인
            this.cars.add(car); // 자동차 객체 추가
        }
    }

    // 각 경기
    public void eachRace() {
        for (Car car : cars ) {
            car.tryMove();
            maxDistance = Math.max(car.getDistance(), maxDistance); // Math 라이브러리로 최대값 계산
            RaceResult.printCarPosition(car); // 자동차 현재 상황 출력
        }
    }

    // 레이스 시작
    public void start(int time) {
        System.out.println("실행 결과");
        for (int i=0; i<time; i++) {
            eachRace();
            System.out.println();
        }
    }

    public List<Car> getWinners() {
        List<Car> winners = new ArrayList<>();
        for (Car car: cars) {
            if (car.getDistance() == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }
}