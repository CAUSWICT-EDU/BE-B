package entity;

import java.util.ArrayList;

public class Winner {
    // ArrayList를 사용해서 동적할당
    private String winner="";
    private ArrayList<Cars> carArrList = new ArrayList<>();;

//    public Winner(Cars[] carsList){
//        this.carArrList = carArrList;
//    }
    // 길이 체크
    public void checkWinner(Cars[] cars){
        int len = 0;
        for(Cars car : cars){
            if(car.getLocation() == len) carArrList.add(car);
            else if(car.getLocation() > len){
                carArrList.clear();
                len = car.getLocation();
                carArrList.add(car);
            }
        }
    }
    // string 으로 바꾸기
    public String StringWinner(){
        for(Cars car : carArrList){
            winner += car.getName()+", ";
        }
        if(winner.length() >2) winner = winner.substring(0,winner.length()-2);
        return winner;
    }
}
