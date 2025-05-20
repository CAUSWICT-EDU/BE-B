package view;

import VO.RacingCarOutputVO;

import java.util.ArrayList;

//유저와 상호작용을 담당하는 클래스
public class RacingCarOutput {
    //유저로부터 최초 입력을 받는 메서드
    public void racingCarFinalOutput(RacingCarOutputVO vo) {
        ArrayList<String> logString = new ArrayList<>();

        for (int i = 0; i < vo.getCarNames().size(); i++){
            logString.add("");
        }

        for (int i = 0; i < vo.getAttemptCount(); i++){
            for (int j = 0; j < vo.getCarNames().size(); j++){
                if (vo.getLogs().get(j).get(i) == 1){
                    logString.set(j, logString.get(j) + "-");
                }
            }
            for (int k = 0; k < vo.getCarNames().size(); k++){
                System.out.println(vo.getCarNames().get(k)+": "+logString.get(k));
            }
            System.out.println();
        }
        System.out.println("최종우승자: "+ String.join(", ", vo.getWinners()));
    }

}