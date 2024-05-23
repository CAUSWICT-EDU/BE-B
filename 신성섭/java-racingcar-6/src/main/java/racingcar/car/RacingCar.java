package racingcar.car;

public class RacingCar implements CarImp{

    private final String name;
    private int movementCount;

    public RacingCar(String name) {
        this.name = name;
        this.movementCount = 0;
    }

    @Override
    public void moveforward() {
        this.movementCount += 1;
    }

    public String getName() {
        return name;
    }

    public int getMovementCount() {
        return movementCount;
    }

}
