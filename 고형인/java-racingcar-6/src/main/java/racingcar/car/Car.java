package racingcar.car;

public class Car { // 자동차 정보
    public String name;
    public int distance;

    // 기본 생성자
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

    public void move(int ranNum) {
        if (ranNum >= 4) {
            this.distance++;
        }
    }

    public void printDistance() {
        System.out.print(this.name + " : ");
        for (int i=0;i<this.distance;i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}