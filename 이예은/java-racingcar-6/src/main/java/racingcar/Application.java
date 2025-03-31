package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

public class Application {
    public static void main(String[] args) {
        sub function = new sub();
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(아룸은 쉼표(,) 기준으로 구분)");
            function.names();
            System.out.println("시도할 회수는 몇회인가요?");
            String y = Console.readLine();
            function.count(y);
        }
        catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        System.out.println("실행 결과");
        for (int i = 0; i <= function.name.length; i++) {
            function.scoresystem();
        }
        function.victory();

    }
}

