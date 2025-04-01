package VO;

public class RacingCarInputVO {

    private String userInputCarName;

    private String[] carNames;

    private int attemptCount = -1;

    public int getAttemptCount() {
        return attemptCount;
    }
    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }
    public String[] getCarNames() {
        return carNames;
    }
    public void setCarNames(String[] carNames) {
        this.carNames = carNames;
    }

    public String getUserInputCarName() {
        return userInputCarName;
    }
    public void setUserInputCarName(String userInputCarName) {
        this.userInputCarName = userInputCarName;
    }
}