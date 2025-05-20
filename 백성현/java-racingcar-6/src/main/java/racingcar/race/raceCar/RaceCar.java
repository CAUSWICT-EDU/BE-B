package racingcar.race.raceCar;

import racingcar.race.raceMain.RaceState;

public class RaceCar {
    private String car_name;
    private int count;  // "-" 출력할 개수
    private RaceState state;
    private StringBuilder bar = new StringBuilder("");
    private RaceState curr_state;


    public RaceState getCurr_state() {
        return curr_state;
    }

    public void setCurr_state(RaceState curr_state) {
        this.curr_state = curr_state;
    }

    public StringBuilder getBar() {
        return bar;
    }

    public void setBar(StringBuilder bar) {
        this.bar = bar;
    }


    public RaceCar(RaceState state) {
        this.state = state;
    }

    public RaceCar(String car_name) {
        this.car_name = car_name;
    }

    public RaceCar(String car_name, int total_count) {
        this.car_name = car_name;
        this.count = total_count;
    }

    public RaceCar(String car_name, RaceState state) {
        this.car_name = car_name;
        this.state = state;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public RaceState getState() {
        return state;
    }

    public void setState(RaceState state) {
        this.state = state;
    }
}
