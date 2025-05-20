package racingcar.race.contorll.input;

import java.util.Scanner;

public class GetRaceCarInputServiceImpl implements GetRaceCarInputService {

    @Override
    public String[] getCarInput() {

        Scanner carScanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carInput = carScanner.nextLine();

        return carInput.split(",");
    }


    @Override
    public int getTryCount() {
        System.out.print("시도할 회수는 몇회인가요? ");
        Scanner tryCountScanner = new Scanner(System.in);
        return tryCountScanner.nextInt(); // 진행 횟수
    }

}
