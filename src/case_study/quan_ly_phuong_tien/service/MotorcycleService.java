package case_study.quan_ly_phuong_tien.service;

import case_study.quan_ly_phuong_tien.repository.IVehicleRepository;
import case_study.quan_ly_phuong_tien.model.Motorcycle;
import case_study.quan_ly_phuong_tien.repository.MotorcycleRepository;

import java.util.List;

public class MotorcycleService implements IVehicleService<Motorcycle> {
    private IVehicleRepository <Motorcycle> motorcycleRepository = new MotorcycleRepository();

    @Override
    public void addVehicle(Motorcycle motorcycle) {
       motorcycleRepository.addVehicle(motorcycle);
    }

    @Override
    public List<Motorcycle> getVehicles() {
        return motorcycleRepository.getVehicles();
    }

    @Override
    public Motorcycle getByLicensePlate(String licensePlate) {
        return motorcycleRepository.getByLicensePlate(licensePlate);
    }

    @Override
    public void delete(Motorcycle motorcycle) {
        motorcycleRepository.delete(motorcycle);
    }

    @Override
    public List<Motorcycle> searchLicensePlate(String licensePlate) {
        return motorcycleRepository.searchLicensePlate(licensePlate);
    }

}
