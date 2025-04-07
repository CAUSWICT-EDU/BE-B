package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        // initialize - 1 자동차 목록 입력
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] carNames = input.split(",");

        // initialize - 2 시도 횟수 입력
        System.out.println("시도할 회수는 몇회인가요?");
        String sTryCount = Console.readLine();
        int tryCount = Validator.tryCountValidator(sTryCount);

        Cars cars = new Cars(carNames);

        RacingGame.playGame(cars, tryCount, new RandomMovingStrategy());

        System.out.println("실행 결과");
        RacingGame.printWinners(cars);
    }
}
