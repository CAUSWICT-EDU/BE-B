package racingcar.serviceimpl;

import racingcar.service.InputService;

import java.util.Scanner;

public class CountInputServiceImpl implements InputService {
    @Override
    public String getInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        Scanner countScanner = new Scanner(System.in);
        String time = countScanner.nextLine();

        // 정수값 입력 여부 검증
        try {
            int timeTypeCheck = Integer.parseInt(time);
            return time;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }
}