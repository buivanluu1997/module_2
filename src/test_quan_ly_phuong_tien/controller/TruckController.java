package test_quan_ly_phuong_tien.controller;

import test_quan_ly_phuong_tien.model.Car;
import test_quan_ly_phuong_tien.model.Truck;
import test_quan_ly_phuong_tien.service.CarService;
import test_quan_ly_phuong_tien.service.IVehicleService;
import test_quan_ly_phuong_tien.service.TruckService;

import java.util.List;

public class TruckController {
    private IVehicleService<Truck> truckService = new TruckService();
    public void add(Truck object) {
        truckService.add(object);
    }


    public List<Truck> getAll() {
        return truckService.getAll();
    }


    public Truck findLicensePlate(String licensePlate) {
        return truckService.findLicensePlate(licensePlate);
    }


    public void delete(Truck object) {
        truckService.delete(object);
    }


    public List<Truck> search(String licensePlate) {
        return truckService.search(licensePlate);
    }
}
