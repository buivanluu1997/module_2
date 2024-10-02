package case_study.quan_ly_phuong_tien.service;

import case_study.quan_ly_phuong_tien.repository.IVehicleRepository;
import case_study.quan_ly_phuong_tien.model.Car;
import case_study.quan_ly_phuong_tien.repository.CarRepository;

import java.util.List;

public class CarService implements IVehicleService<Car> {
    private IVehicleRepository<Car> carRepository = new CarRepository();


    @Override
    public void addVehicle(Car car) {
        carRepository.addVehicle(car);
    }

    @Override
    public List<Car> getVehicles() {
        return carRepository.getVehicles();
    }

    @Override
    public Car getByLicensePlate(String licensePlate) {
         return carRepository.getByLicensePlate(licensePlate);
    }

    @Override
    public void delete(Car car) {
        carRepository.delete(car);
    }

    @Override
    public List<Car> searchLicensePlate(String licensePlate) {
        return carRepository.searchLicensePlate(licensePlate);
    }

}
