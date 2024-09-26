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

    {
        otoList.add(new Oto("75A.21532", manufacturerList.get(3), 2014, "Nguyễn Văn Trung", 4, "Dịch Vụ"));
        motorcycleList.add((new Motorcycle("75C1.16171", manufacturerList.get(1), 2020, "Trần Ngọc Anh", 125)));
        truckList.add(new Truck("43C.24514", manufacturerList.get(2), 2016, "Bùi Ngọc Thạch", 3.5));
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

    @Override
    public boolean deleteVehicle(String licensePlate) {

        for (int i = 0; i < otoList.size(); i++) {
            if (otoList.get(i).getLicensePlate().equals(licensePlate)) {
                otoList.remove(i);
                return true;
            }
        }


        for (int i = 0; i < truckList.size(); i++) {
            if (truckList.get(i).getLicensePlate().equals(licensePlate)) {
                truckList.remove(i);
                return true;
            }
        }

        for (int i = 0; i < motorcycleList.size(); i++) {
            if (motorcycleList.get(i).getLicensePlate().equals(licensePlate)) {
                motorcycleList.remove(i);
                return true;
            }
        }
        return false;
    }
}
