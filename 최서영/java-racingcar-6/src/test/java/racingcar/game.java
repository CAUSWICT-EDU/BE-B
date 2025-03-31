package racingcar;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import racingcar.car;

public class game {
    private final Scanner scanner = new Scanner(System.in);
    private final List<car> cars = new ArrayList<>();

    public void start() {
        inputCarName();
        int tryNum = inputtryNum();
        race(tryNum);
        printWinners();
        scanner.close();
    }

    private void inputCarName() {
        while (true) {
            try {
                System.out.print("경주할 자동차 이름을 입력하세요.(쉼표(,)기준으로 구분) \n");
                String carNameInput = scanner.nextLine();
                String[] carName = carNameInput.split(",");

                cars.clear();
                for (String name : carName) {
                    name = name.trim();
                    cars.add(new car(name));
                }
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int inputtryNum() {
        while (true) {
            try {
                System.out.print("시도할 회수는 몇회 인가요? \n");
                int tryNum = Integer.parseInt(scanner.nextLine());
                if (tryNum <= 0) {
                    throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다.");
                }
                return tryNum;
            } catch (NumberFormatException e) {
                System.out.println("숫자만 입력가능합니다. ");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void race(int attempts) {
        for (int i = 0; i < attempts; i++) {
            System.out.println( );
            for (car car : cars) {
                car.move();
                System.out.println(car.getName() + " : " + car.getPositionString());
            }
        }
    }

    private void printWinners() {
        int maxPosition = cars.stream().mapToInt(car::getPosition).max().orElse(0);
        List<String> winners = new ArrayList<>();
        for (car car : cars) {
            if (car.getPosition() == maxPosition) {
                winners.add(car.getName());
            }
        }
        System.out.println("\n 최종 우승자 : " + String.join(", ", winners));
    }
}
