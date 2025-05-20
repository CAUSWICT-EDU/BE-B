package dev.racingcar.demo.service;

import dev.racingcar.demo.dto.RacingCarOutputDto;
import dev.racingcar.demo.dto.RacingCarDto;

import java.util.List;

public interface RacingCarResultService {
    RacingCarOutputDto racingCarResult(List<RacingCarDto> list);
}