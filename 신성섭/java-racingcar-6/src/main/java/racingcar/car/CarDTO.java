package racingcar.car;

public class CarDTO {
    // DB에 있는 Car 객체의 데이터 무결성을 지키기 위한 Data Transform Object( 단순 데이터 전달용 객체 )
    private final String name;
    private final int movementCount;
    public CarDTO(String name, int movementCount) {
        this.name = name;
        this.movementCount = movementCount;
    }

    public String getName() {
        return name;
    }

    public int getMovementCount() {
        return movementCount;
    }
}
