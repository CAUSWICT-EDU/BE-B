package racingcar;

import java.util.Scanner;

public class RaceInput {
    private String[] carNames;
    private int rounds;

    private void setCarName(int idx, String carName) {
        if (carName.isBlank() || carName.strip().length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 1자 이상 5자 이하로 입력해야 합니다.");
        }
        this.carNames[idx] = carName.strip();
    }

    private void setRounds(int rounds) {
        if (rounds <= 0) {
            throw new IllegalArgumentException("시도할 회수는 1회 이상이어야 합니다.");
        }
        this.rounds = rounds;
    }

    public String[] getCarNames() {
        return carNames;
    }

    public int getRounds() {
        return rounds;
    }

    public void InputCarNames() {
        Scanner sc = new Scanner(System.in);
        System.out.print("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분): ");
        String carNames = sc.nextLine();
        String[] carName = carNames.split(",");
        this.carNames = new String[carName.length];
        for (int i = 0; i < carName.length; i++) {
            setCarName(i, carName[i]);
        }
    }

    public void InputRound() {
        Scanner sc = new Scanner(System.in);
        System.out.print("시도할 회수는 몇회인가요?: ");
        int round = sc.nextInt();
        setRounds(round);
    }
}
