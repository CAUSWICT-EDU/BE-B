package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String[] carNameList = {};
        int N = 0;

        //사용자 입력
        carNameList = inputCarName();
        if(carNameList == null)     return;
        N = inputTryNumber();
        
        //게임 시작
        Game carGame = new Game(carNameList, N);
        carGame.run();

        //게임 결과
        List<String> winners = carGame.whoWinner();

        //결과 출력
        // 리스트 요소를 쉼표와 함께 출력하는 람다 표현식
        String result = winners.stream().collect(Collectors.joining(", "));

        // 최종 결과 출력
        System.out.println("최종 우승자: " + result);
    }

    static String[] inputCarName(){
        String[] carNameList = {};
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,) 기준으로 구분)");
        try {
            carNameList = readLine().split(",");
            for (String i : carNameList) {
//            System.out.println(i);
                if (i.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return null;
        }
        return carNameList;
    }

    static int inputTryNumber(){
        int n = -1;

        try {
            System.out.println("시도할 횟수");
            n = Integer.parseInt(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return n;
    }
}

