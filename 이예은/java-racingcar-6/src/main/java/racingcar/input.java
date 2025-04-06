package racingcar;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;

public class input {
    private ArrayList<Car> carlist = new ArrayList<>();
    private int trynum;

    public input() {}
    Car car = new Car();
    CarMove move = new CarMove();

    public void inputValue() {
        String[] namelist = null;
        try {
            namelist = Console.readLine().split(",");
            if (namelist.length >5||namelist.length <0) {
                throw new IllegalArgumentException("최대 5개의 이름을 입력할 수 있습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        for (String j : namelist)
            carlist.add(new Car(j));
    }

    public void inputtry() {
        trynum = Integer.parseInt(Console.readLine());
        if (trynum<0)
            throw new IllegalArgumentException();
    }

    public ArrayList<Car> getcarlist() {
        return carlist;
    }

    public int getTrynum(){
        return trynum;
    }
}
