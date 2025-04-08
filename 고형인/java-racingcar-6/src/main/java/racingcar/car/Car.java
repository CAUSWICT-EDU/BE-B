package racingcar.car;

import java.util.Random;

public class Car { // 자동차 정보
    private String name;
    private int distance;

    public Car() {
        this.name = "Car0";
        this.distance = 0;
    }

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void setCarName(String carName) {
        this.name = carName;
    }
    public String getCarName() {
        return this.name;
    }

    public void setDistance(int carDistance) {
        this.distance = carDistance;
    }
    public int getDistance() {
        return this.distance;
    }

    public void tryMove() {
        Random random = new Random();
        int ranNum = random.nextInt(10);

        if (ranNum >= 4) {
            this.distance++;
        }
    }

    public void checkName() {
        if (this.name.length() > 5
                || this.name.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
        }
    }
}