package racingcar;
import controller.RacingCarController;

public class Application {



    public static void main(String[] args) {
        // TODO: 프로그램 구현

        RacingCarController racingCarController = new RacingCarController();

        try {
            racingCarController.racingCarStart();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return;
        }

        catch (Exception e){
            System.out.println("알 수 없는 예외상황 발생");
            return;
        }
    }
}




