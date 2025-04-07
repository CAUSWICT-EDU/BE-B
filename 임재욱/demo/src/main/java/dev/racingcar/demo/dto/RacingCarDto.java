package dev.racingcar.demo.dto;

import lombok.Setter;
import lombok.Getter;

import java.util.ArrayList;

@Getter
@Setter
public class RacingCarDto {


    private String carName;

    private ArrayList<Integer> moveLog = new ArrayList<>();

    private int position;



}