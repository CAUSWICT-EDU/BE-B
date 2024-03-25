package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // TODO: 경주할 자동차 이름 입력받기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String [] carNameList = input.nextLine().split(",");

//        for (String name: carNameList) {
//            System.out.println(name.toString());
//        }

        // TODO: 시도할 횟수 입력받기
        System.out.println("시도할 횟수는 몇회인가요?");
        int attemptCount = input.nextInt();


    }

}
