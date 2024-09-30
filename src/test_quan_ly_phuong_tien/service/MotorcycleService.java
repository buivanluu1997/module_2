package test_quan_ly_phuong_tien.service;

import test_quan_ly_phuong_tien.model.Motorcycle;
import test_quan_ly_phuong_tien.repository.IVehicleRepository;
import test_quan_ly_phuong_tien.repository.MotorcycleRepository;

import java.util.List;

public class MotorcycleService implements IVehicleService<Motorcycle> {
    private IVehicleRepository<Motorcycle> motorcycleRepository = new MotorcycleRepository();


    @Override
    public void add(Motorcycle object) {
        motorcycleRepository.add(object);
    }

    @Override
    public List<Motorcycle> getAll() {
        return motorcycleRepository.getAll();
    }

    @Override
    public Motorcycle findLicensePlate(String licensePlate) {
        return motorcycleRepository.findLicensePlate(licensePlate);
    }

    @Override
    public void delete(Motorcycle object) {
        motorcycleRepository.delete(object);
    }

    @Override
    public List<Motorcycle> search(String licensePlate) {
        return motorcycleRepository.search(licensePlate);
    }
}
