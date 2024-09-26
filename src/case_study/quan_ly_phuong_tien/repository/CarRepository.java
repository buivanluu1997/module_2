package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements IVehicleRepository<Car> {
    private List<Car> carList;
    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();

    public CarRepository() {
        this.carList = new ArrayList<>();
        carList.add(new Car("75A.25412", manufacturerRepository.manufacturerList.get(0), 2020, "Nguyễn Trọng Hoàng", 4, "Dịch vụ"));
    }

    @Override
    public void addVehicle(Car car) {
        carList.add(car);
    }

    @Override
    public List<Car> getVehicles() {
        return carList;
    }

    @Override
    public void delete(Car car) {
        carList.remove(car);
    }


    @Override
    public List<Car> searchLicensePlate(String licensePlate) {
        List<Car> result = new ArrayList<>();

        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate)) {
                result.add(car);
            }
        }
        return result;
    }

    @Override
    public Car getByLicensePlate(String licensePlate) {
        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

}
