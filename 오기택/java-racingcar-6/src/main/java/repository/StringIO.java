package repository;

import entity.Cars;

public class StringIO {
    // 입력받은값 나누는 함수
    public static String[] inputSplit(String name){
        String[] usernames = name.split(",");

        try{checkname(usernames);}
        catch (IllegalArgumentException e) {
            System.err.println("오류 발생 : " + e.getMessage());
            System.exit(1);
        }
        return usernames;
    }
    // 올바른 값인지 체크
    public static void checkname(String[] usernames){
        for(String s: usernames){
            if(s.length()>5)  {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
    }
    // 출력하는 함수 static
    public static void locationNow(Cars[] cars){
        for(Cars car : cars){
            car.getNameLocation();
        }
    }
}
