package racingcar;

import racingcar.service.InputService;
import racingcar.serviceimpl.CarNameInputServiceImpl;
import racingcar.serviceimpl.CountInputServiceImpl;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력 받기
        InputService carNameInputService = new CarNameInputServiceImpl();
        InputService countInputService = new CountInputServiceImpl();

        // 자동차 이름 쌩자 저장
        String rawCarList = carNameInputService.getInput();
        // 횟수 입력 받아서 time에 저장
        int time = Integer.parseInt(countInputService.getInput());

        // 레이싱 가보쟈
        Race race = new Race(rawCarList);
        race.start(time);

        // 우스앚
        race.winner();
    }
}