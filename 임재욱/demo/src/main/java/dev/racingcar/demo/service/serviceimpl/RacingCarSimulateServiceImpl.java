package dev.racingcar.demo.service.serviceimpl;

import dev.racingcar.demo.service.RacingCarSimulateService;
import dev.racingcar.demo.dto.RacingCarInputDto;
import dev.racingcar.demo.dto.RacingCarDto;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;
import java.util.List;


@Service
public class RacingCarSimulateServiceImpl implements RacingCarSimulateService {
    @Override
    public List<RacingCarDto>  racingCarSimulation(RacingCarInputDto inputDto) {
        List<RacingCarDto> result = new ArrayList<>();
        for(int i = 0; i < inputDto.getCarNames().length; i++){
            RacingCarDto vo = new RacingCarDto();
            vo.setCarName(inputDto.getCarNames()[i]);

            result.add(vo);
        }

        for(int i = 0; i < inputDto.getAttemptCount(); i++) {
            simulateOneStep(result);
        }
        return result;

    }

    public void simulateOneStep(List<RacingCarDto> list){
        for (RacingCarDto racingCarDto : list) {
            int goStop = goOrStop();    //1이면 go, 0이면 stop
            racingCarDto.getMoveLog().add(goStop);
            racingCarDto.setPosition(racingCarDto.getPosition() + goStop);
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