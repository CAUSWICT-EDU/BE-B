package racingcar.race;

// 외부 라이브러리 사용할 경우 gradle 수동 수정 필요
import racingcar.car.Car;
import racingcar.view.RaceResult;

import java.util.ArrayList; // 자바 표준 라이브러리 (외부 라이브러리 아님)
import java.util.List;

public class Race {
    // 자동차 동적 배열 리스트
    public ArrayList<Car> cars;
    private int maxDistance = 0;

    public Race() {
        this.cars = new ArrayList<>();
        this.maxDistance = 0;
    }

    public Race(String carNames) {
        this.cars = new ArrayList<>(); // 자동차 동적 배열 리스트에 자동차 넣기
        String[] carNameList = carNames.split(",");
        for (String carName : carNameList) {
            Car car = new Car(carName);
            car.checkName(); // 자동차 이름 확인
            this.cars.add(car); // 자동차 객체 추가
        }
    }

    // 최댓값
    public void max(int compNum) {
        if (maxDistance < compNum) {
            maxDistance = compNum;
        }
    }

    // 각 경기
    public void eachRace() {
        for (Car car : cars ) {
            car.tryMove();
            max(car.distance); // 최대 거리 찾기
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
            if (car.distance == maxDistance) {
                winners.add(car);
            }
        }
        return winners;
    }
}