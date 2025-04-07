package racingcar;

public class Car {
    private final String name;
    private int position = 0;

    public Car() { this.name = null; }
    public Car(String name) {
        this.name = name;
    }
    public String getName() { return name; }
    public int getPosition() { return position; }
    public void setPosition(int position) { this.position = position; }
    public void strategyMove(MovingStrategy strategy) {
        if (strategy.canMove()) {
            position++;
        }
    }
    public void PrintInfo() {
        System.out.println("Name: " + name + " Position: " + position);
    }
}