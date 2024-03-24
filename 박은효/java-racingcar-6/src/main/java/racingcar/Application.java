package racingcar;

import racingcar.Entity.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        /*
        1. 자동차의 이름을 입력 받고 각 자동차마다 Car 객체 생성(위치는 모두 0)
        2. 랜덤으로 정수 값 생성해서 전진 또는 정지 결정(goOrStop)
        3. 매 시도마다 각 자동차의 위치 출력(printLocation)
        4. 시도 종료 후 우승자 결정(setWinner)
         */

        Scanner scanner = new Scanner(System.in);

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = scanner.nextLine();

        System.out.println("시도할 회수는 몇회인가요?");
        int t = scanner.nextInt(); //시도 횟수

        String[] carNames = names.split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName, 0);
            cars.add(car);
        }

        

    }
}
