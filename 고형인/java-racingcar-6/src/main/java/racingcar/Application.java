package racingcar;

import racingcar.race.Race;
import racingcar.service.InputService;
import racingcar.serviceimpl.CarNameInputServiceImpl;
import racingcar.serviceimpl.CountInputServiceImpl;
import racingcar.view.RaceResult;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        InputService carNameInputService = new CarNameInputServiceImpl();
        InputService countInputService = new CountInputServiceImpl();

        String rawCarList = carNameInputService.getInput(); // 자동차 이름 입력
        int time = Integer.parseInt(countInputService.getInput()); // 시도 횟수 입력

        Race race = new Race(rawCarList);
        race.start(time); // 레이싱 (time)번 수행 시작

        RaceResult.printWinners(race); // 우승자 출력
    }
}