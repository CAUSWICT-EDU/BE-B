package racingcar;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 입력 받기
        Input carNameInput = new CarNameInput();
        Input countInput = new CountInput();

        // 자동차 이름 쌩자 저장
        String rawCarList = carNameInput.getInput();
        // 횟수 입력 받아서 time에 저장
        int time = Integer.parseInt(countInput.getInput());

        // 레이싱 가보쟈
        Race race = new Race(rawCarList);
        race.start(time);

        // 우스앚
        race.winner();
    }
}
