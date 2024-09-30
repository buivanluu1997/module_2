package test_quan_ly_phuong_tien.repository;

import test_quan_ly_phuong_tien.model.Car;
import test_quan_ly_phuong_tien.model.Motorcycle;
import test_quan_ly_phuong_tien.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements IVehicleRepository<Truck>{
    private List<Truck> trucks;
    private ManufactureRepository manufactureRepository = new ManufactureRepository();

    public TruckRepository() {
        this.trucks = new ArrayList<>();
        trucks.add(new Truck("75C.22545", manufactureRepository.manufactures.get(2), 2020, "Lê Toàn", 3.5));
        trucks.add(new Truck("75C.22111", manufactureRepository.manufactures.get(1), 2022, "Hoàng Dũng", 2.75));
    }

    @Override
    public void add(Truck object) {
        trucks.add(object);
    }

    @Override
    public List<Truck> getAll() {
        return trucks;
    }

    @Override
    public Truck findLicensePlate(String licensePlate) {
        for (Truck truck : trucks) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                return truck;
            }
        }
        return null;
    }

    @Override
    public void delete(Truck object) {
        trucks.remove(object);
    }

    @Override
    public List<Truck> search(String licensePlate) {
        List<Truck> result = new ArrayList<>();
        for (Truck truck : trucks) {
            if (truck.getLicensePlate().toLowerCase().contains(licensePlate.toLowerCase())) {
                result.add(truck);
            }
        }
        return result;
    }
}
