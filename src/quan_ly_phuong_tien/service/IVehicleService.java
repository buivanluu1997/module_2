package quan_ly_phuong_tien.service;

import quan_ly_phuong_tien.model.Manufacturer;
import quan_ly_phuong_tien.model.Motorcycle;
import quan_ly_phuong_tien.model.Oto;
import quan_ly_phuong_tien.model.Truck;

import java.util.List;

public interface IVehicleService {
    List<Manufacturer> manufacturers();

    List<Oto> displayListOto();

    List<Truck> displayListTruck();

    List<Motorcycle> displayListMotorcycle();

    void addVehicle(Oto oto);

    void addVehicle(Motorcycle motorcycle);

    void addVehicle(Truck truck);

    boolean deleteVehicle(String licensePlate);

}
