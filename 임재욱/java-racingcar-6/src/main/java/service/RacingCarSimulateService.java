package service;
import VO.RacingCarInputVO;
import VO.RacingCarVO;

import java.util.List;

public interface RacingCarSimulateService {
    List<RacingCarVO> racingCarSimulation(RacingCarInputVO vo);
    void simulateOneStep(List<RacingCarVO> list);
    int goOrStop();
}