package racingcar;

public class Application {
    public static void main(String[] args) {
        Car car = new Car();
        input input = new input();
        CarMove move = new CarMove(input);

        System.out.println("경주할 자동차 이름을 입력하세요.(아룸은 쉼표(,) 기준으로 구분)");
        input.inputValue();

        System.out.println("시도할 회수는 몇회인가요?");
        input.inputtry();

        for(int i = 0; i < input.getTrynum(); i++) {
            move.carGame();
            for (Car out : input.getcarlist()) {
                System.out.println(out.getName() + " : " + "-".repeat(out.getPosition()));
            }
            System.out.println();
        }

        String winner = move.carCompare();
        System.out.println("최종 우승자: "+winner);
    }
}//기본값설정(이름, 이동횟수) 전진 멈춤 우승조건 우승출력

