package demo_case.quan_ly_phuong_tien.service;

import demo_case.quan_ly_phuong_tien.model.Truck;
import demo_case.quan_ly_phuong_tien.repository.IVehicleRepository;
import demo_case.quan_ly_phuong_tien.repository.TruckRepository;

import java.util.List;

public class TruckService implements IVehicleService<Truck>{
    private IVehicleRepository<Truck> truckRepository = new TruckRepository();
    @Override
    public List<Truck> findAll() {
        return truckRepository.findAll();
    }

    @Override
    public void add(Truck entity) {
        truckRepository.add(entity);
    }

    @Override
    public void delete(Truck entity) {
        truckRepository.delete(entity);
    }

    @Override
    public Truck findByLicensePlate(String licensePlate) {
        return truckRepository.findByLicensePlate(licensePlate);
    }
}
