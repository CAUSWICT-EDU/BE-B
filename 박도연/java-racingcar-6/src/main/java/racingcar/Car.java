package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
//    private static final int MAX_NAME_LENGTH = 5; (Position 검증?)
    private final String name;
    private int step;

    public Car(String _name) {
        this.name = _name;
        this.step = 0;
    }

    //  TODO: 자동차 이름 exception

    public void accelerate(){
        step++;
    }

    public int getStep(){
        return step;
    }

    public String getName(){
        return name;
    }

    public  void moveForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            step++;
        }
    }

    public void printStatus() {
        System.out.print(this.getName() + " : ");
        for (int i = 0; i < step; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public void printInfo() {
        System.out.println("이름: " + name + ", 현재 위치: " + step);
    }
}