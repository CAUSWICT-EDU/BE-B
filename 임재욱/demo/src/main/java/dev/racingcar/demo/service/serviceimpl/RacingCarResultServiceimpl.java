package dev.racingcar.demo.service.serviceimpl;

import dev.racingcar.demo.dto.RacingCarOutputDto;
import dev.racingcar.demo.dto.RacingCarDto;

import dev.racingcar.demo.service.RacingCarResultService;

import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
public class RacingCarResultServiceimpl implements RacingCarResultService {
    @Override
    public RacingCarOutputDto racingCarResult(List<RacingCarDto> list) {


        RacingCarOutputDto result = new RacingCarOutputDto();
        ArrayList<String> winners = new ArrayList<>();
        int max = -1;

        ArrayList<String> carNames = new ArrayList<>();

        for (RacingCarDto racingCarVO : list) {

            //이름 저장
            carNames.add(racingCarVO.getCarName());

            //기록 저장
            result.getLogs().add(racingCarVO.getMoveLog());

            //최댓값 찾기
            if (max < racingCarVO.getPosition()){
                winners.clear();
                winners.add(racingCarVO.getCarName());
                max = racingCarVO.getPosition();
            }
            else if (max == racingCarVO.getPosition()){
                winners.add(racingCarVO.getCarName());
            }
            else{
                continue;
            }
        }

        result.setAttemptCount(list.get(0).getMoveLog().size());

        result.setCarNames(carNames);

        result.setWinners(winners);

        return result;
    }
}