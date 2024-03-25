package racingcar;

class Car {
    // 속성
    protected String name;
    protected int moveCount = 0;

    // 생성자
    Car (String name) {
        this.name = name;
    }

    // 전진 메서드
    protected void move() {
        this.moveCount += 1;
    }


}
