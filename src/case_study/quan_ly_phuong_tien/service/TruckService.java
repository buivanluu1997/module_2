package case_study.quan_ly_phuong_tien.service;

import case_study.quan_ly_phuong_tien.repository.IVehicleRepository;
import case_study.quan_ly_phuong_tien.model.Truck;
import case_study.quan_ly_phuong_tien.repository.TruckRepository;

import java.util.List;

public class TruckService implements IVehicleService<Truck> {

    private IVehicleRepository<Truck> truckRepository = new TruckRepository();

    @Override
    public void addVehicle(Truck truck) {
        truckRepository.addVehicle(truck);
    }

    @Override
    public List<Truck> getVehicles() {
        return truckRepository.getVehicles();
    }

    @Override
    public Truck getByLicensePlate(String licensePlate) {
        return truckRepository.getByLicensePlate(licensePlate);
    }

    @Override
    public void delete(Truck truck) {
        truckRepository.delete(truck);
    }

    @Override
    public List<Truck> searchLicensePlate(String licensePlate) {
        return truckRepository.searchLicensePlate(licensePlate);
    }

}
