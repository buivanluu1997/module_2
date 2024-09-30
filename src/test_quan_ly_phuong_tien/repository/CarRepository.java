package test_quan_ly_phuong_tien.repository;

import test_quan_ly_phuong_tien.model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements IVehicleRepository<Car>{
    private List<Car> carList;
    private ManufactureRepository manufactureRepository = new ManufactureRepository();

    public CarRepository() {
        this.carList = new ArrayList<>();
        carList.add(new Car("75A.22345", manufactureRepository.manufactures.get(0), 2020, "Nguyễn Văn Bình", 4, "dịch vụ"));
        carList.add(new Car("75A.21155", manufactureRepository.manufactures.get(1), 2022, "Trần Minh Hoàng", 30, "du lịch"));
    }

    @Override
    public void add(Car object) {
        carList.add(object);
    }

    @Override
    public List<Car> getAll() {
        return carList;
    }

    @Override
    public Car findLicensePlate(String licensePlate) {
        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void delete(Car object) {
        carList.remove(object);
    }

    @Override
    public List<Car> search(String licensePlate) {
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.getLicensePlate().toLowerCase().contains(licensePlate.toLowerCase())) {
                result.add(car);
            }
        }
        return result;
    }
}
