package demo_case.quan_ly_phuong_tien.service;

import demo_case.quan_ly_phuong_tien.model.Car;
import demo_case.quan_ly_phuong_tien.repository.CarRepository;
import demo_case.quan_ly_phuong_tien.repository.IVehicleRepository;

import java.util.List;

public class CarService implements IVehicleService<Car>{
    private IVehicleRepository<Car> carRepository = new CarRepository();

    @Override
    public List<Car> findAll() {
        return carRepository.findAll();
    }

    @Override
    public void add(Car entity) {
        carRepository.add(entity);
    }

    @Override
    public void delete(Car entity) {
        carRepository.delete(entity);
    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
        return carRepository.findByLicensePlate(licensePlate);
    }
}
