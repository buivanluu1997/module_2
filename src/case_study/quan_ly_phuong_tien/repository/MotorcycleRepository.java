package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Motorcycle;


import java.util.ArrayList;
import java.util.List;

public class MotorcycleRepository implements IVehicleRepository<Motorcycle> {

    private List<Motorcycle> motorcycleList;
    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();

    public MotorcycleRepository() {
        this.motorcycleList = new ArrayList<>();
        motorcycleList.add(new Motorcycle("75C1.16161", manufacturerRepository.manufacturerList.get(2), 2021, "Ngô Thanh Trúc", 125));
    }

    @Override
    public void addVehicle(Motorcycle motorcycle) {
        motorcycleList.add(motorcycle);
    }

    @Override
    public List<Motorcycle> getVehicles() {
        return motorcycleList;
    }


    @Override
    public void delete(Motorcycle motorcycle) {
        motorcycleList.remove(motorcycle);
    }

    @Override
    public List<Motorcycle> searchLicensePlate(String licensePlate) {
        List<Motorcycle> result = new ArrayList<>();

        for (Motorcycle motorcycle : motorcycleList) {
            if (motorcycle.getLicensePlate().equals(licensePlate)) {
                result.add(motorcycle);
            }
        }
        return result;
    }


    @Override
    public Motorcycle getByLicensePlate(String licensePlate) {
        for (Motorcycle motorcycle : motorcycleList) {
            if (motorcycle.getLicensePlate().equals(licensePlate)) {
                return motorcycle;
            }
        }
        return null;
    }

}
