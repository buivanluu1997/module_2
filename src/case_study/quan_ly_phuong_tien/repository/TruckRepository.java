package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements IVehicleRepository<Truck> {

    private List<Truck> truckList;
    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();

    public TruckRepository() {
        this.truckList = new ArrayList<>();
        truckList.add(new Truck("75C.25252", manufacturerRepository.manufacturerList.get(1), 2019, "Trần Thành Trung", 3.5));
    }

    @Override
    public void addVehicle(Truck object) {
        truckList.add(object);
    }

    @Override
    public List<Truck> getVehicles() {
        return truckList;
    }

    @Override
    public void delete(Truck truck) {
        truckList.remove(truck);
    }

    @Override
    public List<Truck> searchLicensePlate(String licensePlate) {
        List<Truck> result = new ArrayList<>();

        for (Truck truck : truckList) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                result.add(truck);
            }
        }
        return result;
    }

    @Override
    public Truck getByLicensePlate(String licensePlate) {
        for (Truck truck : truckList) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                return truck;
            }
        }
        return null;
    }

}
