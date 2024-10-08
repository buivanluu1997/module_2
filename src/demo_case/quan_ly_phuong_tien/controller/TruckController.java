package demo_case.quan_ly_phuong_tien.controller;

import demo_case.quan_ly_phuong_tien.model.Truck;
import demo_case.quan_ly_phuong_tien.service.IVehicleService;
import demo_case.quan_ly_phuong_tien.service.TruckService;

import java.util.List;

public class TruckController {
    private IVehicleService<Truck> truckService = new TruckService();

    public List<Truck> findAll() {
        return truckService.findAll();
    }

    public void add(Truck truck) {
        truckService.add(truck);
    }

    public void delete(Truck entity) {
        truckService.delete(entity);
    }

    public Truck findByLicensePlate(String licensePlate) {
        return truckService.findByLicensePlate(licensePlate);
    }
}
