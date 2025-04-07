package dev.racingcar.demo.service;
import dev.racingcar.demo.dto.RacingCarInputDto;
import dev.racingcar.demo.dto.RacingCarDto;


import java.util.List;


public interface RacingCarSimulateService {
    List<RacingCarDto> racingCarSimulation(RacingCarInputDto inputDto);
    void simulateOneStep(List<RacingCarDto> list);
    int goOrStop();
}