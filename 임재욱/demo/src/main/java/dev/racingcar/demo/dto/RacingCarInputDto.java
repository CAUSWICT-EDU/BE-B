package dev.racingcar.demo.dto;

import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
public class RacingCarInputDto {

    private String userInputCarName;

    private String[] carNames;

    private int attemptCount = -1;

}