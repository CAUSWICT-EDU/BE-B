package racingcar;

import java.util.Random;

public class RacingCar {
    private String carname;
    private int position = 0;
    public RacingCar(String name) {
        this.carname = name;
    }

    public void race() {
        Random rand = new Random();
        if (rand.nextInt(10) >= 4) {
            this.position++;
        }
    }

    public String getName() {
        return this.carname;
    }

    public int getPosition() {
        return this.position;
    }
}
