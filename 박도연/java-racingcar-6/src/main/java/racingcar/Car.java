package racingcar;

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

    public void printInfo() {
        System.out.println("이름: " + name + ", 현재 위치: " + step);
    }
}