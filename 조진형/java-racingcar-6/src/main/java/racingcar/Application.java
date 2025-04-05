package racingcar;

public class Application {
    public static void main(String[] args) {
        Race race = new Race();
        RaceInput raceInput = new RaceInput();
        raceInput.InputCarNames();
        race.setCars(raceInput.getCarNames());
        raceInput.InputRound();
        for (int i = 0; i < raceInput.getRounds(); i++) {
            race.doRace();
            race.printResult();
        }
        race.getWinner();
    }
}
