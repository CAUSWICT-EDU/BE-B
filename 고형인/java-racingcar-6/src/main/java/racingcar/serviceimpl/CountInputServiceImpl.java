package racingcar.serviceimpl;

import racingcar.service.InputService;

import java.util.Scanner;

public class CountInputServiceImpl implements InputService {
    @Override
    public String getInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner countScanner = new Scanner(System.in);
        return countScanner.nextLine();
    }
}