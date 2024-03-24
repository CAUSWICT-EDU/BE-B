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

    @Override
    public void goOrStop(CarInterface car) {

    }

    @Override
    public void printLocation(CarInterface car) {

    }
}
