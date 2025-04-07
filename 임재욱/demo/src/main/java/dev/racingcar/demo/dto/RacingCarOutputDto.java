package dev.racingcar.demo.dto;

import java.util.ArrayList;
import java.util.List;
import lombok.Setter;
import lombok.Getter;

@Setter
@Getter
public class RacingCarOutputDto {
    private ArrayList<String> winners = new ArrayList<>();
    private List<ArrayList<Integer>> logs = new ArrayList<>();
    private ArrayList<String> carNames = new ArrayList<>();
    private int attemptCount;
}
