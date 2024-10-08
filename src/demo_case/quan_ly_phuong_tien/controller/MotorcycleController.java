package demo_case.quan_ly_phuong_tien.controller;

import demo_case.quan_ly_phuong_tien.model.Motorcycle;
import demo_case.quan_ly_phuong_tien.service.IVehicleService;
import demo_case.quan_ly_phuong_tien.service.MotorcycleService;

import java.util.List;

public class MotorcycleController {
    private IVehicleService<Motorcycle> motorcycleService = new MotorcycleService();
    public List<Motorcycle> findAll() {
        return motorcycleService.findAll();
    }

    public void add(Motorcycle entity) {
        motorcycleService.add(entity);
    }

    public void delete(Motorcycle entity) {
        motorcycleService.delete(entity);
    }

    public Motorcycle findByLicensePlate(String licensePlate) {
        return motorcycleService.findByLicensePlate(licensePlate);
    }
}
