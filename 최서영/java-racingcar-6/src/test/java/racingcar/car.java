package racingcar;

public class car {
    private final String name;
    private int position;

    public car(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
        this.name = name;
        this.position = 0;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    public void move() {
        if (Math.random() * 10 >= 4) {
            position++;
        }
    }

    public String getPositionString() {
        return "-".repeat(position);
    }
}
