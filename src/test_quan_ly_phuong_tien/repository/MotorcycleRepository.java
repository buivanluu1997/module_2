package test_quan_ly_phuong_tien.repository;

import test_quan_ly_phuong_tien.model.Car;
import test_quan_ly_phuong_tien.model.Motorcycle;

import java.util.ArrayList;
import java.util.List;

public class MotorcycleRepository implements IVehicleRepository<Motorcycle>{
    private List<Motorcycle> motorcycles;
    private ManufactureRepository manufactureRepository = new ManufactureRepository();
    @Override
    public void add(Motorcycle object) {
        this.motorcycles = new ArrayList<>();
        motorcycles.add(new Motorcycle("75C1.12345", manufactureRepository.manufactures.get(2), 2021, "Hoàng Ngọc Huy", 125));
        motorcycles.add(new Motorcycle("75C1.12355", manufactureRepository.manufactures.get(1), 2024, "Bùi Ngọc Thạch", 125));
    }

    @Override
    public List<Motorcycle> getAll() {
        return motorcycles;
    }

    @Override
    public Motorcycle findLicensePlate(String licensePlate) {
        for (Motorcycle motorcycle : motorcycles) {
            if (motorcycle.getLicensePlate().equals(licensePlate)) {
                return motorcycle;
            }
        }
        return null;
    }

    @Override
    public void delete(Motorcycle object) {
        motorcycles.remove(object);
    }

    @Override
    public List<Motorcycle> search(String licensePlate) {
        List<Motorcycle> result = new ArrayList<>();
        for (Motorcycle motorcycle : motorcycles) {
            if (motorcycle.getLicensePlate().toLowerCase().contains(licensePlate.toLowerCase())) {
                result.add(motorcycle);
            }
        }
        return result;
    }
}
