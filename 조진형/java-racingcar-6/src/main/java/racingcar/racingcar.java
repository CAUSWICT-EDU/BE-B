package racingcar;

import java.util.Random;

public class racingcar {
    final String carname;
    private int position = 0;
    public racingcar(String name) {
        this.carname = name;
    }

    public void race() {
        Random rand = new Random();
        if (rand.nextInt(10) >= 4) {
            this.position++;
        }
        System.out.println(this.carname + " : " + "-".repeat(this.position));
    }

    public int getPosition() {
        return this.position;
    }
}
