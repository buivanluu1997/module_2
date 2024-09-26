package case_study.quan_ly_phuong_tien.controller;

import case_study.quan_ly_phuong_tien.service.IVehicleService;
import case_study.quan_ly_phuong_tien.model.Truck;
import case_study.quan_ly_phuong_tien.service.TruckService;

import java.util.List;

public class TruckController {
    private IVehicleService<Truck> truckService = new TruckService();

    public void addVehicle(Truck truck) {
        truckService.addVehicle(truck);
    }


    public List<Truck> getVehicles() {
        return truckService.getVehicles();
    }


    public Truck getByLicensePlate(String licensePlate) {
        return truckService.getByLicensePlate(licensePlate);
    }


    public void delete(Truck truck) {
        truckService.delete(truck);
    }


    public List<Truck> searchLicensePlate(String licensePlate) {
        return truckService.searchLicensePlate(licensePlate);
    }

}
