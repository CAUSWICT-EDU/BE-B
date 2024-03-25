package racingcar;

class Car {
    // 속성
    String name;
    int moveCount = 0;

    // 생성자
    Car (String name) {
        this.name = name;
    }

    // 전진 메서드
    void move() {
        this.moveCount += 1;
    }


}
