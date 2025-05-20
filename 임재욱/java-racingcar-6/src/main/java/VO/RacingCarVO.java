package VO;

import java.util.ArrayList;

public class RacingCarVO {


    private String carName;

    private ArrayList<Integer> moveLog = new ArrayList<>();

    private int position;


    public ArrayList<Integer> getMoveLog() {
        return moveLog;
    }
    public void setMoveLog(ArrayList<Integer> moveLog) {
        this.moveLog = moveLog;
    }


    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }


    public String getCarName() {
        return carName;
    }
    public void setCarName(String carName) {
        this.carName = carName;
    }


}