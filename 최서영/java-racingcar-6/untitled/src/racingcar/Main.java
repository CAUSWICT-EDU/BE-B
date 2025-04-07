package racingcar;

import racingcar.controll.Race;
import racingcar.view.InputView;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> carNames = InputView.getCarNames();
        int attemptCount = InputView.getAttemptCount();

        Race race = new Race(carNames, attemptCount);
        race.start();  // 게임 시작
    }
}
