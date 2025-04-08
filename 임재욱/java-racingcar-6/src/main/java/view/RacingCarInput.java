package view;

import java.util.Scanner;
import VO.RacingCarInputVO;

//유저와 상호작용을 담당하는 클래스
public class RacingCarInput {
    //유저로부터 최초 입력을 받는 메서드
    public  RacingCarInputVO racingCarFirstInput() throws Exception{
        RacingCarInputVO vo = new RacingCarInputVO();
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주 할 자동차 이름(이름은 쉼표(,) 기준으로 구분)");
        vo.setUserInputCarName(scanner.nextLine());
        System.out.println("시도할 회수");
        try{
            vo.setAttemptCount(Integer.parseInt(scanner.nextLine()));
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효하지 않은 시도 횟수 숫자 입력");
        }

        return vo;
    }


}