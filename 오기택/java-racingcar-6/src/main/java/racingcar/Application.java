package racingcar;

import entity.Cars;
import entity.Winner;
import repository.GamePlay;
import repository.StringIO;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // 이름 입력받기
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String name = scanner.nextLine();

        // split을 통해 나누기 ,배열에 생성하기
        String[] usernames = StringIO.inputSplit(name);
        int len = usernames.length;

        // 이동 횟수 이력받기
        System.out.println("시도할 회수는 몇회인가요?");
        int moveInt = scanner.nextInt();



        // for문을 통해 각 배열에 car객체 생성 (이름 예외처리)
        Cars[] carsList = new Cars[len];
        for(int i=0; i< len;i++) {
            //예외처리
            Cars car = new Cars(usernames[i]);
            carsList[i] = car;
        }
        for(int i=0;i<moveInt;i++){
            GamePlay.move(carsList);
            StringIO.locationNow(carsList);
        }
        // winner class를 통해 우승자 뽑기
        Winner winner = new Winner();
        winner.checkWinner(carsList);
        String result =winner.StringWinner();

        System.out.println("최종 우승자 : "+result);
    }
}
