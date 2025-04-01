package service.serviceimpl;

import service.RacingCarSimulateService;
import VO.RacingCarInputVO;
import VO.RacingCarVO;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;



public class RacingCarSimulateServiceImpl implements RacingCarSimulateService {
    @Override
    public List<RacingCarVO>  racingCarSimulation(RacingCarInputVO inputvo) {
        List<RacingCarVO> result = new ArrayList<>();
        for(int i = 0; i < inputvo.getCarNames().length; i++){
            RacingCarVO vo = new RacingCarVO();
            vo.setCarName(inputvo.getCarNames()[i]);

            result.add(vo);
        }

        for(int i = 0; i < inputvo.getAttemptCount(); i++) {
            simulateOneStep(result);
        }
        return result;

    }

    public void simulateOneStep(List<RacingCarVO> list){
        for (RacingCarVO racingCarVO : list) {
            int goStop = goOrStop();    //1이면 go, 0이면 stop
            racingCarVO.getMoveLog().add(goStop);
            racingCarVO.setPosition(racingCarVO.getPosition() + goStop);
        }
    }

    public int goOrStop(){
        Random random = new Random();
        int randomNumber = random.nextInt(10);
        if (randomNumber>=4){
            return 1;
        }
        else{
            return 0;
        }
    }

}