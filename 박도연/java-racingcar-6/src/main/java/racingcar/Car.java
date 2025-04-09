package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private static final int MAX_NAME_LENGTH = 5;
    private final String name;
    private int step;

    public Car(String _name) {
        this.checkName(_name);
        this.name = _name;
        this.step = 0;
    }

    private void checkName(String _name) {
        if (_name == null || _name.trim().isEmpty()) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }

        if (_name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
        }

        if (_name.contains(",")) {
            throw new IllegalArgumentException("자동차 이름에 ','를 포함할 수 없습니다.");
        }
    }

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
            accelerate();
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