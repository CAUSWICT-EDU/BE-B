public class Car {
    private final String name;
    private int position = 0;

    public Car() {}
    public Car(String name) {
        this.name = name;
    }
    public String GetName() { return name; }
    public int GetPosition() { return position; }
    public void SetPosition(int position) { this.position = position; }
    public void Move(MovingStrategy strategy) {
        if (strategy.canMove()) {
            position++;
        }
    }
    public void PrintInfo() {
        System.out.println("Name: " + name + " Position: " + position);
    }
}