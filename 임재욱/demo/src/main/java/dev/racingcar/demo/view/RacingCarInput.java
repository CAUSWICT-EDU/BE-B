package dev.racingcar.demo.view;

import java.util.Scanner;
import dev.racingcar.demo.dto.RacingCarInputDto;
import org.springframework.stereotype.Component;

@Component
//유저와 상호작용을 담당하는 클래스
public class RacingCarInput {

    public RacingCarInput(){}

    //유저로부터 최초 입력을 받는 메서드
    public  RacingCarInputDto racingCarFirstInput() throws Exception{
        RacingCarInputDto dto = new RacingCarInputDto();
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        dto.setUserInputCarName(scanner.nextLine());
        System.out.println("시도할 회수");
        try{
            dto.setAttemptCount(Integer.parseInt(scanner.nextLine()));
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수 숫자 입력");
        }

        return dto;
    }


}