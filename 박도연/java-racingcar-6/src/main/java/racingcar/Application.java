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

        // TODO: tryCount에 대한 exception 구현
        int iTryCount = Integer.parseInt(sTryCount);

        // TODO: Car 객체 구성할 때 name과 trycount에 대한 exception 구현
        // initalize - 3 자동차 객체 생성
        Car[] cars = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            cars[i] = new Car(carNames[i]);
        }

        // process - moveForward, printStatus
        System.out.println("실행 결과");
        for (int i = 0; i < iTryCount; i++) {
            for (Car car : cars){
                car.moveForward();
                car.printStatus();
            }
            System.out.println();
        }

        // terminate
        int maxStep = 0;
        for (Car car : cars){
            if (car.getStep() > maxStep){
                maxStep = car.getStep();
            }
        }
        StringBuilder winner = new StringBuilder();
        for (Car car : cars) {
            if (car.getStep() != maxStep) {
                continue;
            }
            if (winner.length() > 0) {
                winner.append(", ");
            }
            winner.append(car.getName());
        }
        System.out.println("최종 우승자 : " + winner);
    }
}
