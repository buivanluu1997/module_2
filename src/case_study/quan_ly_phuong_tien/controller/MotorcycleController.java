package case_study.quan_ly_phuong_tien.controller;

import case_study.quan_ly_phuong_tien.service.IVehicleService;
import case_study.quan_ly_phuong_tien.model.Motorcycle;
import case_study.quan_ly_phuong_tien.service.MotorcycleService;

import java.util.List;

public class MotorcycleController {
    private IVehicleService<Motorcycle> motorcycleService = new MotorcycleService();

    public void addVehicle(Motorcycle motorcycle) {
        motorcycleService.addVehicle(motorcycle);
    }


    public List<Motorcycle> getVehicles() {
        return motorcycleService.getVehicles();
    }


    public Motorcycle getByLicensePlate(String licensePlate) {
        return motorcycleService.getByLicensePlate(licensePlate);
    }


    public void delete(Motorcycle motorcycle) {
        motorcycleService.delete(motorcycle);
    }


    public List<Motorcycle> searchLicensePlate(String licensePlate) {
        return motorcycleService.searchLicensePlate(licensePlate);
    }

    public void readFile() {
        motorcycleService.readFile();
    }

    public void writeFile() {
        motorcycleService.writeFile();
    }
}
