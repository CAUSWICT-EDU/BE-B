package racingcar;

import java.util.Scanner;

public class CarMove {
    Car car = new Car();
    private input input;

    public CarMove(){}
    public CarMove(input input) { // 생성자로 주입
        this.input = input;
    }

    public String carCompare(){
        int max = 0;
        String winners = "";
        for(Car i : input.getcarlist()){
            if(i.getPosition()>max) {
                max = i.getPosition();
                winners = i.getName();
            }
            else if(i.getPosition()==max){

            }
        }
        return winners;
    }

    public void carGame() {
        for(Car i : input.getcarlist())
            i.move();
    }
}

