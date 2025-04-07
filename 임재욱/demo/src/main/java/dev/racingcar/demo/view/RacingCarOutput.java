package dev.racingcar.demo.view;

import dev.racingcar.demo.dto.RacingCarOutputDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
//유저와 상호작용을 담당하는 클래스
public class RacingCarOutput {

    public RacingCarOutput(){}

    //유저로부터 최초 입력을 받는 메서드
    public void racingCarFinalOutput(RacingCarOutputDto dto) {
        ArrayList<String> logString = new ArrayList<>();

        for (int i = 0; i < dto.getCarNames().size(); i++){
            logString.add("");
        }

        for (int i = 0; i < dto.getAttemptCount(); i++){
            for (int j = 0; j < dto.getCarNames().size(); j++){
                if (dto.getLogs().get(j).get(i) == 1){
                    logString.set(j, logString.get(j) + "-");
                }
            }
            for (int k = 0; k < dto.getCarNames().size(); k++){
                System.out.println(dto.getCarNames().get(k)+": "+logString.get(k));
            }
            System.out.println();
        }
        System.out.println("최종우승자: "+ String.join(", ", dto.getWinners()));
    }

}