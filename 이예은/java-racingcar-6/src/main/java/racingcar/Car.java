package racingcar;
import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private int position=0;
    private String name;

    public Car(){}
    public Car(String name) {
        this.name = name;
    }

    public int move() {
        int random = Randoms.pickNumberInRange(0, 9);
        if (random >= 4)
            position++;
        return position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }


}

