package racingcar;

class Car {
    // TODO: 멤버 변수: 사용자 이름, 전진 횟수
    String name;
    int moveCount = 0;

    //생성자
    Car (String name) {
        this.name = name;
    }

    // TODO: 메서드: 전진
    //
    void move() {
        this.moveCount += 1;
    }


}
