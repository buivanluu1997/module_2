package demo_case.quan_ly_phuong_tien.controller;

import demo_case.quan_ly_phuong_tien.model.Car;
import demo_case.quan_ly_phuong_tien.service.CarService;
import demo_case.quan_ly_phuong_tien.service.IVehicleService;

import java.util.List;

public class CarController {
    private IVehicleService<Car> carService = new CarService();

    public List<Car> findAll() {
        return carService.findAll();
    }
    public void add(Car entity) {
        carService.add(entity);
    }

    public void delete(Car entity) {
        carService.delete(entity);
    }

    public Car findByLicensePlate(String licensePlate) {
        return carService.findByLicensePlate(licensePlate);
    }
}
