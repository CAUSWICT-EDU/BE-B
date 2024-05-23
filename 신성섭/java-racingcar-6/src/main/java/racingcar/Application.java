package racingcar;

import racingcar.cardb.CarDbImp;
import racingcar.cardb.RacingCarDb;
import racingcar.racinggamemanager.GameManagerImp;
import racingcar.racinggamemanager.RacingGameManager;

public class Application {
    public static void main(String[] args) {

        GameManagerImp myRacingGame = new RacingGameManager();
        CarDbImp myRacingCarDb = new RacingCarDb();
        myRacingGame.setCarDb(myRacingCarDb);

        myRacingGame.run();

    }
}
