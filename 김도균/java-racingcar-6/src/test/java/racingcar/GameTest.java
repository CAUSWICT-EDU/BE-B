package racingcar;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    @Test
    public void testMakeCarList() {

        // 테스트할 자동차 이름 배열
        String[] carNames = {"Sonata", "Kona", "Tucson"};

        Game game1 = new Game(carNames, 3);

        // 예상되는 Car 객체 리스트
        List<Car> expectedCarList = List.of(new Car("Sonata"), new Car("Kona"), new Car("Tucson"));

        // makeCarList() 메서드 호출
        List<Car> actualCarList = game1.makeCarList(carNames);

        // 예상된 결과와 실제 결과 비교
        assertEquals(expectedCarList.size(), actualCarList.size(), "리스트 크기가 다릅니다.");
        for (int i = 0; i < expectedCarList.size(); i++) {
            assertEquals(expectedCarList.get(i).getName(), actualCarList.get(i).getName(), "자동차 이름이 다릅니다.");
        }
    }

}