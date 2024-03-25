package racingcar;

import java.util.ArrayList;

public class RacingGame {
    // 속성
    ArrayList<Car> carArray;
    ArrayList<String> winnerList = new ArrayList<>();
    int roundCount;

    // 생성자
    RacingGame(ArrayList<Car> cars, int roundCount) {
        this.carArray = cars;
        this.roundCount = roundCount;
    }

    // 랜덤 수 리턴 메서드
    int getRandomNumber() {
        return (int) (Math.random() * 10); // 0에서 9사이(10 미포함)
    }

    // 라운드 결과 출력 메서드
    void printRoundResult() {
        for (Car car : carArray) {
            System.out.println(car.name + " : " + "-".repeat(car.moveCount));
        }
        System.out.println();
    }

    // 라운드 진행 메서드
    void playRound() {
        for (Car car : carArray) {
            if (this.getRandomNumber() >= 4) {
                car.move();
            }
        }
    }

    // 가장 먼 거리 찾는 메서드
    int getMaxMoveCount() {
        int max = carArray.get(0).moveCount;

        for (int i = 1; i < carArray.size(); i++) {
            int toCompare = carArray.get(i).moveCount;
            if (max < toCompare) {
                max = toCompare;
            }
        }

        return max;
    }

    // 우승자 결정 메서드
    void decideFinalWinner(int max) {
        System.out.print("최종 우승자: ");

        // winnerList 우승자들 추가
        for (Car  car : carArray) {
            if (car.moveCount == max) {
                winnerList.add(car.name);
            }
        }
        // 우승자 출력
        String finalWinners = String.join(", ", winnerList);
        System.out.println(finalWinners);
    }


    // 게임 진행
    void playGame() {
        System.out.println("실행 결과");

        for (int i = 0; i < this.roundCount; i++) {
            this.playRound();
            this.printRoundResult();
        }

        int maxMoveCount = this.getMaxMoveCount();
        this.decideFinalWinner(maxMoveCount);

    }
}
