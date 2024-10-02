package case_study.quan_ly_phuong_tien.controller;

import case_study.quan_ly_phuong_tien.service.IVehicleService;
import case_study.quan_ly_phuong_tien.model.Car;
import case_study.quan_ly_phuong_tien.service.CarService;

import java.util.List;

public class CarController {
    private IVehicleService<Car> carService = new CarService();

    public void addVehicle(Car car) {
        carService.addVehicle(car);
    }


    public List<Car> getVehicles() {
        return carService.getVehicles();
    }


    public Car getByLicensePlate(String licensePlate) {
        return carService.getByLicensePlate(licensePlate);
    }


    public void delete(Car car) {
        carService.delete(car);
    }


    public List<Car> searchLicensePlate(String licensePlate) {
        return carService.searchLicensePlate(licensePlate);
    }

}
