package racingcar;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class Car {

    private String name;
    private int step = 0; //자동차가 얼마나 전진했는지 (initial : 0)

    public Car(String name) {
        this.name = name;
    }

    /***
     * 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우 전진한다.
     */
    public void tryForward() {
        if(pickNumberInRange(0, 9) >= 4){
            this.step++;
        }
    }

    public String getName() {
        return name;
    }

    public int getStep() {
        return step;
    }

}
