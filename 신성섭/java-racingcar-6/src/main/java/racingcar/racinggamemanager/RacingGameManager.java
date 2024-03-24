package racingcar.racinggamemanager;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.car.CarDTO;
import racingcar.car.RacingCar;
import racingcar.cardb.CarDbImp;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class RacingGameManager implements GameManagerImp {

    private CarDbImp racingCarDb;
    private int currentTurn; //현재 턴
    private int totalTurn; // 게임의 총 턴수

    public RacingGameManager(){ }


    @Override
    public void run() {
        setupGame(); //게임의 초기 설정을 한다.

        while ( currentTurn < totalTurn ){
            currentTurn+=1;
            updateCarMove(); // 모든 자동차의 움직임임을 업데이트 해준다.
            if(currentTurn == 1){
                System.out.println("실행결과");
            }
            printRoundResult(); // 매 라운드 마다 경기 결과를 보여준다.

        }

        printWinner(); // 최종 우승자를 보여준다.
    }

    private void setupGame(){
        this.currentTurn = 0;
        setRacingCars();
        setTotalTurn();
    }

    private void setRacingCars(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분 , 각 자동차는 최대 5글자까지 가능)");
        String wantedCarNames = readLine();
        String[] carNames = wantedCarNames.split(",");

        for (String carName : carNames) {
            carName = carName.trim(); // 공백 제거
            if (carName.length() <= 5) {
                racingCarDb.addCar( new RacingCar(carName) );
            } else {
                throw new IllegalArgumentException("자동차 이름은 5글자 이하여야 합니다. 프로그램을 강제 종료합니다.");
            }
        }
        System.out.println();
    }

    private void setTotalTurn(){

        System.out.println("시도할 회수는 몇회인가요?");
        String wantedTotalTurn = readLine();
        wantedTotalTurn = wantedTotalTurn.trim(); // 공백 제거

        try{
            this.totalTurn = Integer.parseInt(wantedTotalTurn);

        }catch (NumberFormatException e){
            //구현의 조건으로 입력 예외 발생시 애플리케이션 종료를 요구함.
            //실제 프로그램이라면 프로그램의 강제 종료는 복구 불가능한 에러의 경우에만 해야함.
            //반복문을 통해 올바른 값을 입력 하도록 다시 요구하는 것이 옳은 설계 방향.

            System.out.println();
            throw new IllegalArgumentException("사용자가 잘못된 형식의 턴수를 입력하였습니다. 프로그램을 강제 종료합니다.",e);
        }
    }

    private void updateCarMove(){
        int carCount = racingCarDb.getCarCount();
        for (int ithCar = 0; ithCar < carCount; ithCar++){
            int randomNum = Randoms.pickNumberInRange(MIN_RANDOM_NUM, MAX_RANDOM_NUM);
            if (randomNum >= MOVEMENT_LIMIT){
                racingCarDb.carMove(ithCar);
            }
        }
    }

    private void printRoundResult(){
        int carCount = racingCarDb.getCarCount();
        for (int ithCar =0 ; ithCar < carCount ; ithCar++){
            CarDTO racingCar = racingCarDb.getCarInformation(ithCar);
            System.out.println(racingCar.getName() + " : " +  "-".repeat(racingCar.getMovementCount()));
        }
        System.out.println();
    }

    private void printWinner(){
        List<String> winners = findWinner();
        int winnerCount =  winners.size();

        System.out.print("최종 우승자 : ");
        for(int ithCar = 0 ; ithCar < winnerCount-1 ; ithCar++){
            System.out.print(winners.get(ithCar)+", ");
        }

        System.out.println(winners.get(winnerCount-1));

    }

    private List<String> findWinner(){
        List<String> MaxCarNames= new ArrayList<>();
        int carCount = racingCarDb.getCarCount();
        int MaxMove=-1;

        for(int ithCar=0; ithCar < carCount; ithCar++){
            CarDTO carInfo = racingCarDb.getCarInformation(ithCar);

            String carName= carInfo.getName();
            int movementCount = carInfo.getMovementCount();

            if(MaxMove < movementCount){
                MaxMove = movementCount;
                MaxCarNames.clear(); // 기존에 있던 차들 이름을 지워주기
                MaxCarNames.add(carName);
            } else if (MaxMove == movementCount) {
                MaxCarNames.add(carName);
            }

        }

        return MaxCarNames;
    }


    @Override
    public void setCarDb(CarDbImp racingCarDb) {
        this.racingCarDb = racingCarDb;
    }

}
