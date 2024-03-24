package racingcar.cardb;

import racingcar.car.CarDTO;
import racingcar.car.CarImp;

public interface CarDbImp {
    public void addCar(CarImp car);

    public void carMove(int ithCar);


    public int getCarCount();

    public CarDTO getCarInformation(int ithCar);
}
