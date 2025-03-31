package racingcar;

import camp.nextstep.edu.missionutils.Console;

// 자동차 입력 받기
public class CarNameInput implements Input {
    @Override
    public String getInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }
}
