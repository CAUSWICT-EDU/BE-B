package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String[] carNameList;
    private int n;  //시도할 횟수
    private List<Car> carList;

    public Game(String[] carNameList, int n) {
        this.carNameList = carNameList;
        this.n = n;
    }

    /***
     * 자동차 이름을 갖고 자동차 객체를 생성하자.
     *  자동차 이름 개수 -> 반복문으로 객체 생성
     */
    public List<Car> makeCarList(String[] carNameList){
        List<Car> list = new ArrayList<>();
        //사용자가 입력한 자동차 이름으로 Car 객체 생성한다.
        for(int i=0;i<carNameList.length;i++){
            list.add(new Car(carNameList[i]));
        }

        return list;
    }
}
