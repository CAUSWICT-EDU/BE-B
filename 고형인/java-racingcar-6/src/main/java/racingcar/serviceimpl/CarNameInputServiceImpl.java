package racingcar.serviceimpl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.InputService;

// 자동차 입력 받기
public class CarNameInputServiceImpl implements InputService {
    @Override
    public String getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }
}