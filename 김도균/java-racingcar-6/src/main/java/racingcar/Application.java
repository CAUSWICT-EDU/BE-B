package racingcar;

import java.util.List;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String[] carNameList = {};
        int N = 0;

        //사용자 입력
        carNameList = inputCarName();
        N = inputTryNumber();
        
//        //입력 테스트
//        for(String carName : carNameList){
//            System.out.println(carName);
//        }
//        System.out.println(N);
        
        //게임 시작
        
        //게임 결과
        
        //결과 출력
    }

    static String[] inputCarName(){
        String[] carNameList = {};
        System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,) 기준으로 구분)");
        try {
            carNameList = readLine().split(",");
            for (String i : carNameList) {
//            System.out.println(i);
                if (i.length() > 5) throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return carNameList;
    }

    static int inputTryNumber(){
        int n = -1;

        try {
            System.out.println("시도할 횟수");
            n = Integer.parseInt(readLine());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return n;
    }
}

