package test_quan_ly_phuong_tien.service;

import test_quan_ly_phuong_tien.model.Car;
import test_quan_ly_phuong_tien.repository.CarRepository;
import test_quan_ly_phuong_tien.repository.IVehicleRepository;

import java.util.List;

public class CarService implements IVehicleService<Car> {
    private IVehicleRepository<Car> carRepository = new CarRepository();
    @Override
    public void add(Car car) {
        carRepository.add(car);
    }

    @Override
    public List<Car> getAll() {
        return carRepository.getAll();
    }

    @Override
    public Car findLicensePlate(String licensePlate) {
        return carRepository.findLicensePlate(licensePlate);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public List<Car> search(String licensePlate) {
        return carRepository.search(licensePlate);
    }
}
