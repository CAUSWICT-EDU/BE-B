package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class CountInput implements Input {
    @Override
    public String getInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}
