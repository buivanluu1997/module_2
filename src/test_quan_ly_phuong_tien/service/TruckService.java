package test_quan_ly_phuong_tien.service;

import test_quan_ly_phuong_tien.model.Truck;
import test_quan_ly_phuong_tien.repository.IVehicleRepository;
import test_quan_ly_phuong_tien.repository.TruckRepository;

import java.util.List;

public class TruckService implements IVehicleService<Truck> {
    private IVehicleRepository<Truck> truckRepository = new TruckRepository();
    @Override
    public void add(Truck object) {
        truckRepository.add(object);
    }

    @Override
    public List<Truck> getAll() {
        return truckRepository.getAll();
    }

    @Override
    public Truck findLicensePlate(String licensePlate) {
        return truckRepository.findLicensePlate(licensePlate);
    }

    @Override
    public void delete(Truck object) {
        truckRepository.delete(object);
    }

    @Override
    public List<Truck> search(String licensePlate) {
        return truckRepository.search(licensePlate);
    }
}
