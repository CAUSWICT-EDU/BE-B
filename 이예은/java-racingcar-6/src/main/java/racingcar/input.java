package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class input {
    private ArrayList<Car> carlist = new ArrayList<>();
    private int trynum;

    Car car = new Car();
    CarMove move = new CarMove();

    public void inputValue() {
        String[] namelist = Console.readLine().split(",");
        for(String j : namelist)
            carlist.add(new Car(j));
    }

    public void inputtry() {
        trynum = Integer.parseInt(Console.readLine());
    }

    public ArrayList<Car> getcarlist() {
        return carlist;
    }

    public int getTrynum(){
        return trynum;
    }
}
