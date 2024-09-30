package test_quan_ly_phuong_tien.controller;

import test_quan_ly_phuong_tien.model.Car;
import test_quan_ly_phuong_tien.model.Motorcycle;
import test_quan_ly_phuong_tien.service.CarService;
import test_quan_ly_phuong_tien.service.IVehicleService;
import test_quan_ly_phuong_tien.service.MotorcycleService;

import java.util.List;

public class MotorcycleController {
    private IVehicleService<Motorcycle> motorcycleService = new MotorcycleService();
    public void add(Motorcycle object) {
        motorcycleService.add(object);
    }


    public List<Motorcycle> getAll() {
        return motorcycleService.getAll();
    }


    public Motorcycle findLicensePlate(String licensePlate) {
        return motorcycleService.findLicensePlate(licensePlate);
    }


    public void delete(Motorcycle object) {
        motorcycleService.delete(object);
    }


    public List<Motorcycle> search(String licensePlate) {
        return motorcycleService.search(licensePlate);
    }
}
