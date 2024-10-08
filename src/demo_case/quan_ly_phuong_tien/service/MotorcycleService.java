package demo_case.quan_ly_phuong_tien.service;

import demo_case.quan_ly_phuong_tien.model.Motorcycle;
import demo_case.quan_ly_phuong_tien.repository.IVehicleRepository;
import demo_case.quan_ly_phuong_tien.repository.MotorcycleRepository;

import java.util.List;

public class MotorcycleService implements IVehicleService<Motorcycle> {
    private IVehicleRepository<Motorcycle> motorcycleRepository = new MotorcycleRepository();

    @Override
    public List<Motorcycle> findAll() {
        return motorcycleRepository.findAll();
    }

    @Override
    public void add(Motorcycle entity) {
        motorcycleRepository.add(entity);
    }

    @Override
    public void delete(Motorcycle entity) {
        motorcycleRepository.delete(entity);
    }

    @Override
    public Motorcycle findByLicensePlate(String licensePlate) {
        return motorcycleRepository.findByLicensePlate(licensePlate);
    }
}
