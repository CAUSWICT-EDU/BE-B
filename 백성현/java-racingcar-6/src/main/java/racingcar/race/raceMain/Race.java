package racingcar.race.raceMain;

import racingcar.race.raceCar.RaceCar;

public class Race {
    private String car_name;
    private int random_number;
    private RaceState check_state;
    private RaceCar race_car;


    // getter
    public String getCar_name() {
        return car_name;
    }

    public int getRandom_number() {
        return random_number;
    }

    public RaceState getCheck_state() {
        return check_state;
    }

    public RaceCar getRace_car() {
        return race_car;
    }


    // setter
    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public void setCheck_state(RaceState check_state) {
        this.check_state = check_state;
    }

    public void setRandom_number(int random_number) {
        this.random_number = random_number;
    }

    public void setRace_car(RaceCar race_car) {
        this.race_car = race_car;
    }
}
