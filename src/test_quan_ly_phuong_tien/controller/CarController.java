package test_quan_ly_phuong_tien.controller;

import test_quan_ly_phuong_tien.model.Car;
import test_quan_ly_phuong_tien.service.CarService;
import test_quan_ly_phuong_tien.service.IVehicleService;

import java.util.List;

public class CarController {
    private IVehicleService<Car> carService = new CarService();

    public void add(Car object) {
        carService.add(object);
    }


    public List<Car> getAll() {
        return carService.getAll();
    }


    public Car findLicensePlate(String licensePlate) {
        return carService.findLicensePlate(licensePlate);
    }


    public void delete(Car object) {
        carService.delete(object);
    }


    public List<Car> search(String licensePlate) {
        return carService.search(licensePlate);
    }
}
