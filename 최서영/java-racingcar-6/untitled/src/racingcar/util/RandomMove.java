package racingcar.util;

import java.util.Random;
public class RandomMove {
    private static final Random random = new Random();

    public static int getRandomNumber() {
        return random.nextInt(10);  // 0 이상 10 미만의 랜덤 숫자 생성
    }

}
