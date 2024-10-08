package demo_case.quan_ly_phuong_tien.repository;

import demo_case.quan_ly_phuong_tien.model.Car;
import demo_case.quan_ly_phuong_tien.model.Truck;
import demo_case.quan_ly_phuong_tien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements IVehicleRepository <Truck>{
    private final String FILE_TRUCK = "src/demo_case/quan_ly_phuong_tien/data/truck.csv";

    @Override
    public void writeFile(List<Truck> list) {
        List<String> stringList = new ArrayList<>();
        for (Truck truck : list) {
            stringList.add(truck.csvTruck());
        }
        ReadWriteFile.writeFile(FILE_TRUCK, stringList, false);
    }

    @Override
    public List<Truck> findAll() {
        List<String> stringList = ReadWriteFile.readFile(FILE_TRUCK);
        List<Truck> truckList = new ArrayList<>();
        for (String line : stringList) {
            String[] arr = line.split(",");
            String licensePlate = arr[0];
            String nameManufacturer = arr[1];
            int year = Integer.parseInt(arr[2]);
            String owner = arr[3];
            double payload = Double.parseDouble(arr[4]);

            Truck truck = new Truck(licensePlate, nameManufacturer, year, owner, payload);
            truckList.add(truck);
        }
        return truckList;
    }

    @Override
    public void add(Truck entity) {
        List<Truck> truckList = findAll();
        truckList.add(entity);

        writeFile(truckList);
    }

    @Override
    public void delete(Truck entity) {
        List<Truck> truckList = findAll();
        for (Truck truck : truckList) {
            if(truck.getLicensePlate().equals(entity.getLicensePlate())) {
                truckList.remove(truck);
                break;
            }
        }
        writeFile(truckList);
    }

    @Override
    public Truck findByLicensePlate(String licensePlate) {
        List<Truck> truckList = findAll();
        for (Truck truck : truckList) {
            if(truck.getLicensePlate().equals(licensePlate)) {
                return truck;
            }
        }
        return null;
    }
}
