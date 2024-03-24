package racingcar.cardb;

import racingcar.car.CarDTO;
import racingcar.car.CarImp;

import java.util.ArrayList;
import java.util.List;

public class RacingCarDb implements CarDbImp{

    private final List<CarImp> racingCarDb = new ArrayList<>();
    private int racingCarCount= 0;

    @Override
    public void addCar(CarImp car){
        racingCarDb.add(car);
        racingCarCount+=1;
    }

    @Override
    public void carMove(int ithCar) {
        racingCarDb.get(ithCar).moveforward();
    }

    @Override
    public int getCarCount() {
        return this.racingCarCount;
    }

    @Override
    public CarDTO getCarInformation(int ithCar){
        CarImp findCar = racingCarDb.get(ithCar);
        return new CarDTO(findCar.getName(), findCar.getMovementCount());
    }

}
