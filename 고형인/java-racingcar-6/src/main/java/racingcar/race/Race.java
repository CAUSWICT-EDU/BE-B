package racingcar.race;

// 외부 라이브러리 사용할 경우 gradle 수동 수정 필요
import racingcar.Car;

import java.util.ArrayList; // 자바 표준 라이브러리 (외부 라이브러리 아님)
import java.util.Random;

public class Race {
    // 자동차 동적 배열 리스트
    public ArrayList<Car> cars;
    public int maxDistance;

    public Race() {
        this.cars = new ArrayList<>();
        this.maxDistance = 0;
    }

    public Race(String carNames) {
        // 자동차 동적 배열 리스트에 자동차 넣기
        this.cars = new ArrayList<>();
        String[] carNameList = carNames.split(",");
        for (String carName : carNameList) {
            // 자동차 이름 확인
            checkName(carName);
            // 객체 추가
            this.cars.add(new Car(carName));
        }
    }

    public static void checkName(String carName) {
        if (carName.length() > 5
        || carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
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
            Random random = new Random();
            int ranNum = random.nextInt(10);

            car.move(ranNum);
            car.printDistance();
            max(car.distance);
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

    public void printWinner() {
        int counter = 0;
        for (Car car : cars) {
            if (car.distance == maxDistance && counter == 0) {
                System.out.print(car.name);
                counter++;
            }
            else if (car.distance == maxDistance && counter > 0) {
                System.out.print(", " + car.name);
                counter++;
            }
        }
    }

    // 우승자
    public void winner() {
        System.out.print("최종 우승자 : ");
        printWinner();
    }
}