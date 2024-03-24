package entity;

public class Cars {
    // private 이름, 위치 선언
    private String name;
    private String location ="";

    public Cars(String name){
        this.name = name;
    }

    // 이름 : 위치 출력 함수
    public void getNameLocation(){
        System.out.println(this.name+" : "+this.location);
    }
    // 위치 출력 함수
    public int getLocation(){
        return this.location.length();
    }
    // 이름 출력 함수
    public String getName(){
        return this.name;
    }


}
