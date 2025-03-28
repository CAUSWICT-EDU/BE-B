package racingcar.race.raceMain;

import camp.nextstep.edu.missionutils.Randoms;

public class RaceServiceImpl implements RaceService {

    @Override
    public RaceState getState() {
        int random_number = Randoms.pickNumberInRange(0,9);
        System.out.println(random_number);

        if(random_number >= 4) {
            return RaceState.GO;
        } else {
            return RaceState.STAY;
        }
    }




}
