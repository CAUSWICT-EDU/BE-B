package racingcar;

public class Car {
//    private static final int MAX_NAME_LENGTH = 5; (Position 검증?)
    private final String name;
    private int step;

    public Car(String _name) {
        this.name = _name;
        step = 0;

    }
    //  TODO: 자동차 이름 exception

    public void accelerate( void ){
        step++;
    }

    public int getStep(){
        return step;
    }

    public String getName(){
        return name;
    }

}
