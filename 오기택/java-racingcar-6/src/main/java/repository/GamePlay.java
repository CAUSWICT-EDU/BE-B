package repository;

import entity.Cars;

public class GamePlay {
    // 랜덤 돌리기 함수
    public static int randomInt(){
        return (int)(Math.random()*10);
    }
    // 이동 - 정지 함수
    public static void move(Cars[] cars){
        for(Cars car : cars){
            if(randomInt() >= 4) car.setLocation();
        }
    }

}
