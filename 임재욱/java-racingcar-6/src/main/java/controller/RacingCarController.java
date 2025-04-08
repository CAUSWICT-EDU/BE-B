package controller;
import VO.RacingCarOutputVO;
import VO.RacingCarVO;
import service.RacingCarResultService;
import service.serviceimpl.RacingCarResultServiceimpl;
import service.serviceimpl.RacingCarSimulateServiceImpl;
import view.RacingCarInput;
import VO.RacingCarInputVO;
import service.RacingCarSimulateService;
import view.RacingCarOutput;

import java.util.List;

public class RacingCarController {



    public void racingCarStart() throws Exception{

        RacingCarSimulateService racingCarSimulateService = new RacingCarSimulateServiceImpl();
        RacingCarInput input = new RacingCarInput();



        //최초 유저로부터 입력받음
        RacingCarInputVO vo = new RacingCarInputVO();

        vo = input.racingCarFirstInput();

        //유저 입력 데이터 검증
        //자동차 이름부터 검증
        try{
            vo.setCarNames(vo.getUserInputCarName().split(","));
        }
        catch (Exception e){
            throw new IllegalArgumentException("잘못된 자동차 이름 입력 형식");
        }

        for (int i = 0; i < vo.getCarNames().length; i++) {
            String carName = vo.getCarNames()[i].trim();
            if (carName.isEmpty() || carName.length() > 5){
                throw new IllegalArgumentException("허용되지 않는 자동차 이름 길이");
            }
            vo.getCarNames()[i] = carName;
        }

        //시도 횟수 검증
        if (vo.getAttemptCount()<=0){
            throw new IllegalArgumentException("유효하지 않은 시도 횟수");
        }

        //게임 서비스 실행
        List<RacingCarVO> result = racingCarSimulateService.racingCarSimulation(vo);
        racingCarResultEvaluate(result);
    }

    public void racingCarResultEvaluate(List<RacingCarVO> list){

        RacingCarResultService racingCarResultService = new RacingCarResultServiceimpl();
        RacingCarOutput output = new RacingCarOutput();

        RacingCarOutputVO result = racingCarResultService.racingCarResult(list);
        output.racingCarFinalOutput(result);
    }

}