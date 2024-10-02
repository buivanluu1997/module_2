package test_quan_ly_phuong_tien.repository;

import test_quan_ly_phuong_tien.model.Manufacturer;
import test_quan_ly_phuong_tien.model.Truck;
import test_quan_ly_phuong_tien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements IVehicleRepository<Truck> {

    private ManufacturerRepository manufactureRepository = new ManufacturerRepository();
    private final String FILE_CAR_CSV = "src/test_quan_ly_phuong_tien/data/truck.csv";


    @Override
    public void add(Truck truck) {
        List<Truck> trucks = getAll();
        trucks.add(truck);

        writeFileVehicle(trucks);
    }

    @Override
    public List<Truck> getAll() {
        List<String> lines = ReadWriteFile.readFile(FILE_CAR_CSV);
        List<Truck> truckList = new ArrayList<>();
        for (String line : lines) {
            String[] arr = line.split(",");
            String licensePlate = arr[0];
            String manufacturerId = arr[1];
            int year = Integer.parseInt(arr[4]);
            String owner = arr[5];
            double loadCapacity = Double.parseDouble(arr[6]);

            Manufacturer manufacturer = manufactureRepository.findById(manufacturerId);
            Truck truck = new Truck(licensePlate, manufacturer, year, owner, loadCapacity );
            truckList.add(truck);
        }
        return truckList;
    }

    @Override
    public void writeFileVehicle(List<Truck> list) {
        List<String> stringList = new ArrayList<>();

        for (Truck truck : list) {
            String line = truck.convertTruckToLine();
            stringList.add(line);
        }
        ReadWriteFile.writeFile(FILE_CAR_CSV, stringList, false);
    }

    @Override
    public Truck findLicensePlate(String licensePlate) {
        List<Truck> truckList = getAll();
        for (Truck truck : truckList) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                return truck;
            }
        }
        return null;
    }

    @Override
    public void delete(Truck truck) {
        List<Truck> truckList = getAll();
        for (int i = 0; i < truckList.size(); i++) {
            if (truckList.get(i).getLicensePlate().equals(truck.getLicensePlate())) {
                truckList.remove(i);
            }
        }
        writeFileVehicle(truckList);
    }

    @Override
    public List<Truck> search(String licensePlate) {
        List<Truck> truckList = getAll();
        List<Truck> result = new ArrayList<>();
        for (Truck truck : truckList) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                result.add(truck);
            }
        }
        return result;
    }
}
