package quan_ly_phuong_tien.repository;

import quan_ly_phuong_tien.model.Manufacturer;
import quan_ly_phuong_tien.model.Motorcycle;
import quan_ly_phuong_tien.model.Oto;
import quan_ly_phuong_tien.model.Truck;

import java.util.List;

public interface IVehicleRepository {
    List<Manufacturer> manufacturers();

    List<Oto> displayListOto();

    List<Truck> displayListTruck();

    List<Motorcycle> displayListMotorcycle();

    void addVahicle(Oto oto);

    void addVahicle(Truck truck);

    void addVahicle(Motorcycle motorcycle);
}
