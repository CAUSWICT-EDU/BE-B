package racingcar;

import entity.Cars;
import entity.Winner;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 이름, 이동횟수 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name = scanner.nextLine();
        System.out.println("시도할 회수는 몇회인가요?");
        int moveInt = scanner.nextInt();

        // split을 통해 나누기 ,배열에 생성하기
        String[] usernames = name.split(",");


        // for문을 통해 각 배열에 car객체 생성 (이름 예외처리)
        Cars[] carsList = new Cars[usernames.length];
        for(int i=0; i< usernames.length;i++){
            //예외처리
            Cars car = new Cars(usernames[i]);
            carsList[i] = car;
        }


        // winner class를 통해 우승자 뽑기
        Winner winner = new Winner();
        winner.checkWinner(carsList);
        String result =winner.StringWinner();
        System.out.println("최종 우승자 : "+result);
    }
}
