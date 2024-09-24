package quan_ly_phuong_tien.repository;

import quan_ly_phuong_tien.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleRipository implements IVehicleRepository {
    private List<Oto> otoList = new ArrayList<>();
    private List<Motorcycle> motorcycleList = new ArrayList<>();
    private List<Truck> truckList = new ArrayList<>();
    private List<Manufacturer> manufacturerList = new ArrayList<>();

    {
        manufacturerList.add(new Manufacturer("H01", "HonDa", "Nhật Bản"));
        manufacturerList.add(new Manufacturer("Y01", "Yamaha", "Nhật Bản"));
        manufacturerList.add(new Manufacturer("F01", "Ford", "Mỹ"));
        manufacturerList.add(new Manufacturer("K02", "Kia", "Hàn Quốc"));
    }

    @Override
    public List<Manufacturer> manufacturers() {
        return manufacturerList;
    }

    @Override
    public List<Oto> displayListOto() {
        return otoList;
    }

    @Override
    public List<Truck> displayListTruck() {
        return truckList;
    }

    @Override
    public List<Motorcycle> displayListMotorcycle() {
        return motorcycleList;
    }

    @Override
    public void addVahicle(Oto oto) {
        otoList.add(oto);
    }

    @Override
    public void addVahicle(Truck truck) {
        truckList.add(truck);
    }

    @Override
    public void addVahicle(Motorcycle motorcycle) {
        motorcycleList.add(motorcycle);
    }
}
