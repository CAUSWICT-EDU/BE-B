package dev.racingcar.demo.controller;

import dev.racingcar.demo.dto.RacingCarOutputDto;
import dev.racingcar.demo.dto.RacingCarDto;
import dev.racingcar.demo.dto.RacingCarInputDto;

import dev.racingcar.demo.service.RacingCarResultService;
import dev.racingcar.demo.service.RacingCarSimulateService;

import dev.racingcar.demo.view.RacingCarInput;
import dev.racingcar.demo.view.RacingCarOutput;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class RacingCarController {

    private final RacingCarResultService racingCarResultService;
    private final RacingCarSimulateService racingCarSimulateService;
    private final RacingCarInput racingCarInput;
    private final RacingCarOutput racingCarOutput;

    //의존성 주입
    public RacingCarController(RacingCarResultService racingCarResultService, RacingCarSimulateService racingCarSimulateService, RacingCarInput racingCarInput, RacingCarOutput racingCarOutput){
        this.racingCarResultService = racingCarResultService;
        this.racingCarSimulateService = racingCarSimulateService;
        this.racingCarInput = racingCarInput;
        this.racingCarOutput = racingCarOutput;
    }

    @GetMapping("/start")
    public void racingCarStart() throws Exception{

        //최초 유저로부터 입력받음
        RacingCarInputDto dto = racingCarInput.racingCarFirstInput();

        //유저 입력 데이터 검증 후 서비스 호출
        //자동차 이름부터 검증
        try{
            dto.setCarNames(dto.getUserInputCarName().split(","));
        }
        catch (Exception e){
            throw new IllegalArgumentException("잘못된 자동차 이름 입력 형식");
        }

        for (int i = 0; i < dto.getCarNames().length; i++) {
            String carName = dto.getCarNames()[i].trim();
            if (carName.isEmpty() || carName.length() > 5){
                throw new IllegalArgumentException("허용되지 않는 자동차 이름 길이");
            }
            dto.getCarNames()[i] = carName;
        }

        //시도 횟수 검증
        if (dto.getAttemptCount()<=0){
            throw new IllegalArgumentException("유효하지 않은 시도 횟수");
        }

        //게임 서비스 실행
        List<RacingCarDto> result = racingCarSimulateService.racingCarSimulation(dto);

        //실행 결과를 결과 처리 컨트롤러로 넘김
        racingCarResultEvaluate(result);
        //return "ridirect:/result"
    }

    @GetMapping("/result")
    public void racingCarResultEvaluate(List<RacingCarDto> list){

        //결과를 출력할 수 있도록 가공
        RacingCarOutputDto result = racingCarResultService.racingCarResult(list);

        //결과 출력
        racingCarOutput.racingCarFinalOutput(result);
    }

}