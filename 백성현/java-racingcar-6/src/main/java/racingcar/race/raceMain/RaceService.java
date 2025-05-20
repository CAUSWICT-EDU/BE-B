package racingcar.race.raceMain;

public interface RaceService {

    // 자동차 상태 조회
    RaceState getState(); // GO, STAY 구분
}
