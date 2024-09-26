package quan_ly_phuong_tien.service;

import quan_ly_phuong_tien.model.Manufacturer;
import quan_ly_phuong_tien.model.Motorcycle;
import quan_ly_phuong_tien.model.Oto;
import quan_ly_phuong_tien.model.Truck;
import quan_ly_phuong_tien.repository.IVehicleRepository;
import quan_ly_phuong_tien.repository.VehicleRipository;

import java.util.List;


  public class VehicleService implements IVehicleService {
    private IVehicleRepository vehicleRipository = new VehicleRipository();

    @Override
    public List<Manufacturer> manufacturers() {
        return vehicleRipository.manufacturers();
    }

    @Override
    public List<Oto> displayListOto() {
        return vehicleRipository.displayListOto();
    }

    @Override
    public List<Truck> displayListTruck() {
        return vehicleRipository.displayListTruck();
    }

    @Override
    public List<Motorcycle> displayListMotorcycle() {
        return vehicleRipository.displayListMotorcycle();
    }

    @Override
    public void addVehicle(Oto oto) {
        vehicleRipository.addVahicle(oto);
    }

    @Override
    public void addVehicle(Motorcycle motorcycle) {
        vehicleRipository.addVahicle(motorcycle);
    }

    @Override
    public void addVehicle(Truck truck) {
        vehicleRipository.addVahicle(truck);
    }

      @Override
      public boolean deleteVehicle(String licensePlate) {
          System.out.println("123");
          return vehicleRipository.deleteVehicle(licensePlate);
      }

  }
