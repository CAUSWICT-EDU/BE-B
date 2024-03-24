package racingcar.racinggamemanager;

import racingcar.cardb.CarDbImp;

public interface GameManagerImp {

    public static final int MIN_RANDOM_NUM = 0;
    public static final int MAX_RANDOM_NUM = 9;

    public static final int MOVEMENT_LIMIT = 4; // 움직일 수 있는 최소 숫자

    // 게임을 시작하는 메소드
    public void run();

    public void setCarDb(CarDbImp racingCarDb);

}
