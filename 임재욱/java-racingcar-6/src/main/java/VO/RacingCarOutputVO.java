package VO;

import java.util.ArrayList;
import java.util.List;

public class RacingCarOutputVO {
    private ArrayList<String> winners = new ArrayList<>();
    private List<ArrayList<Integer>> logs = new ArrayList<>();
    private ArrayList<String> carNames = new ArrayList<>();
    private int attemptCount;

    public int getAttemptCount() {
        return attemptCount;
    }
    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public ArrayList<String> getCarNames() {
        return carNames;
    }
    public void setCarNames(ArrayList<String> carNames) {
        this.carNames = carNames;
    }

    public List<ArrayList<Integer>> getLogs() {
        return logs;
    }
    public void setLogs(List<ArrayList<Integer>> logs) {
        this.logs = logs;
    }

    public ArrayList<String> getWinners() {
        return winners;
    }
    public void setWinners(ArrayList<String> winners) {
        this.winners = winners;
    }
}
