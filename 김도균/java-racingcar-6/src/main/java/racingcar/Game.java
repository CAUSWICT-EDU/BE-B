package racingcar;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private String[] carNameList;
    private int n;  //시도할 횟수
    private List<Car> carList;

    public Game(String[] carNameList, int n) {
        this.carNameList = carNameList;
        this.n = n;
    }

    /***
     * 자동차 이름을 갖고 자동차 객체를 생성하자.
     *  자동차 이름 개수 -> 반복문으로 객체 생성
     */
    public List<Car> makeCarList(String[] carNameList){
        List<Car> list = new ArrayList<>();
        //사용자가 입력한 자동차 이름으로 Car 객체 생성한다.
        for(int i=0;i<carNameList.length;i++){
            list.add(new Car(carNameList[i]));
        }

        return list;
    }

    public void run() {
        //사용자가 입력한 자동차 이름으로 Car객체 리스트 생성.
        carList = makeCarList(carNameList);
        System.out.println("실행 결과");
        while(n > 0){
            //Car에게 전진 시도하라고 명령
            for(int i=0; i<carList.size(); i++){
                carList.get(i).tryForward();
            }
            display(carList);
            n--;
        }
    }

    /***
     * 각 차수별 실행 결과를 출력해주는 함수
     * @param carList
     */
    private void display(List<Car> carList){
        //carList size 만큼 출력할 것.
        //각 Car객체의 전진 상황(step)만큼 '-' 출력
        for(int i=0; i<carList.size(); i++){
            Car imsi_car = carList.get(i);
            System.out.print(imsi_car.getName() + ":");
            for(int j=0; j<imsi_car.getStep(); j++){
                System.out.print('-');
            }
            System.out.println();
        }
        System.out.println();
    }

    /***
     * carList에서 step이 가장 높은 Car 객체들의 이름을 list에 담아 반환한다.
     * @return 우승자 이름 list
     */
    public List<String> whoWinner(){
        List<String> winnerList = new ArrayList<>();
        int maxStep = -1;
        // carList를 순회하며 step이 가장 높은 값을 찾는다.
        for (Car car : carList) {
            int step = car.getStep();
            if (step > maxStep) {
                // 더 높은 step을 발견하면 리스트를 초기화하고 현재 자동차의 이름을 추가
                winnerList.clear();
                winnerList.add(car.getName());
                maxStep = step;
            } else if (step == maxStep) {
                // 최고 step과 같은 경우 리스트에 추가합니다.
                winnerList.add(car.getName());
            }
        }
        return winnerList;
    }
}
