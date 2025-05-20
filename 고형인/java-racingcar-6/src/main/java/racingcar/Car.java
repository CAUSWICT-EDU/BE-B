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

    public void printDistance() {
        System.out.print(this.name + " : ");
        for (int i=0;i<this.distance;i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
}