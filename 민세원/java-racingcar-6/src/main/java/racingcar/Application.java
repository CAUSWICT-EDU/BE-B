package racingcar;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Car> carArray = new ArrayList<>(); // Car 객체를 저장할 리스트
        int roundCount; // 시도할 횟수

        try {
            // 경주할 자동차 이름 입력받기
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String [] carNameList = input.nextLine().split(",");

            // Car 객체 생성
            for (String name: carNameList) {
                if (name.length() > 5) {
                    throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
                }
                carArray.add(new Car(name));
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        // 시도할 횟수 입력받기
        System.out.println("시도할 횟수는 몇회인가요?");
        String line = input.nextLine();

        try {
            roundCount = Integer.parseInt(line);

            if (roundCount <= 0) {
              throw new IllegalArgumentException("양의 정수를 입력해주세요.");
            }

            // RacingGame 객체 생성
            RacingGame myRacingGame = new RacingGame(carArray, roundCount);
            myRacingGame.playGame();

        } catch (NumberFormatException e) { // 입력이 숫자가 아닐 경우
            System.out.println("양의 정수를 입력해주세요.");
            return;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }


    }

}
