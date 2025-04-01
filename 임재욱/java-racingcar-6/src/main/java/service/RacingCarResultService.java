package service;

import VO.RacingCarOutputVO;
import VO.RacingCarVO;

import java.util.List;

public interface RacingCarResultService {
    RacingCarOutputVO racingCarResult(List<RacingCarVO> list);
}