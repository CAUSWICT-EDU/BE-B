package racingcar;

// 외부 라이브러리 사용할 경우 gradle 수동 수정 필요
import java.util.ArrayList; // 자바 표준 라이브러리 (외부 라이브러리 아님)
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

// 입력 추상화 클래스
abstract class Input {
    abstract String raceInput();
}
// 자동차 입력 받기
class CarNameInput extends Input {
    @Override
    String raceInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        return Console.readLine();
    }
}
// 시도 횟수 입력 받기
class CountInput extends Input {
    @Override
    String raceInput() {
        System.out.println("시도할 회수는 몇회인가요?");
        return Console.readLine();
    }
}

public class Application {
    //전역 변수
    // 자동차 리스트 전역 변수
    public static ArrayList<Car> cars = new ArrayList<>();
    public static int maxDistance = 0;

    // 리스트에 자동차 객체 추가
    public static void addCar(String name) {
        Car newCar = new Car(name);
        cars.add(newCar);
    }
    // 입력 받은 문자열 잘라서 자동차 리스트 전역 변수에 넣기
    public static void makeCarList(String rawData) {
        String[] splited = rawData.split(",");
        for (String carName : splited) {
            if (carName.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하입니다.");
            }
            addCar(carName);
        }
    }

    // 자동차 이동 거리 출력
    public static void printEachDistance(int distance) {
        if (distance > maxDistance) {
            maxDistance = distance;
        }
        for (int i=0;i<distance;i++) {
            System.out.print("-");
        }
        System.out.print("\n");
    }
    // 자동차 정보 출력
    public static void printEachCar() {
        for (Car car : cars) { // 동적 배열에서는 length 아니고 size
            int ranNum = Randoms.pickNumberInRange(0,9);
            car.move(ranNum);
            System.out.print(car.name + " : ");
            printEachDistance(car.distance);
        }
        System.out.print("\n");
    }

    // 우승자 찾기
    public static void findWinner() {
        int counter = 0;
        for (Car car : cars) {
            if (car.distance == maxDistance && counter == 0) {
                System.out.print(car.name);
                counter++;
            }
            else if (car.distance == maxDistance && counter > 0) {
                System.out.print(", " + car.name);
                counter++;
            }
        }
    }
    // 우승자 출력
    public static void printWinner() {
        System.out.print("최종 우승자 : ");
        findWinner();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력 받기
        CarNameInput CarNameInput = new CarNameInput();
        CountInput CountInput = new CountInput();

        // 자동차 이름 배정
        makeCarList(CarNameInput.raceInput());

        int time = Integer.parseInt(CountInput.raceInput());

        // 레이싱 가보쟈
        System.out.println("실행 결과");
        for (int i=0;i<time;i++) {
            printEachCar();
        }

        // 우승자
        printWinner();
    }
}
