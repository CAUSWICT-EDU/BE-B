package racingcar.serviceimpl;

import camp.nextstep.edu.missionutils.Console;
import racingcar.service.InputService;

public class CountInputServiceImpl implements InputService {
    @Override
    public String getInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}