package racingcar.Entity;

import racingcar.Interface.CarInterface;

public class Car implements CarInterface {
//캡슐화
    private String name;

    private int location;


    public Car(String name, int location) {
        this.name = name;
        this.location = location;
    }

    public void setLocation(int random) {
        if (random >= 4) {
            this.location += 1;
        }
    }

    @Override
    public void goOrStop() {
        int random;
        random = (int)(Math.random() * 10);

        setLocation(random);
    }

    @Override
    public void printLocation() {
        System.out.print(this.name + " : ");
        for (int i = 0; i < this.location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
}
