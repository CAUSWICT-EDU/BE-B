package racingcar;

import java.util.Scanner;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // TODO: 경주할 자동차 이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String [] carNameList = input.nextLine().split(",");

        ArrayList<Car> carArray = new ArrayList<>(); // Car 객체를 저장할 리스트

        // Car 객체 생성
        for (String name: carNameList) {
            carArray.add(new Car(name));
        }

        // TODO: 시도할 횟수 입력받기
        System.out.println("시도할 횟수는 몇회인가요?");
        int roundCount = input.nextInt();

        // RacingGame 객체 생성
        RacingGame myRacingGame = new RacingGame(carArray, roundCount);
        myRacingGame.playGame();

    }

}
