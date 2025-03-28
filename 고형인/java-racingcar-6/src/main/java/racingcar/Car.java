package racingcar;

public class Car { // 자동차 정보
    public String name;
    public int distance;

    public Car(String name) {
        this.name = name;
        this.distance = 0;
    }

    public void move(int ranNum) {
        if (ranNum >= 4) {
            this.distance++;
        }
    }
}