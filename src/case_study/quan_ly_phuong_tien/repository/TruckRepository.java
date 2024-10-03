package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Manufacturer;
import case_study.quan_ly_phuong_tien.model.Motorcycle;
import case_study.quan_ly_phuong_tien.model.Truck;
import case_study.quan_ly_phuong_tien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements IVehicleRepository<Truck> {

    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private final String FILE_VEHICLE = "src/case_study/quan_ly_phuong_tien/data/vehicle.csv";

    public TruckRepository() {}

    @Override
    public void addVehicle(Truck truck) {
        List<String> stringList = new ArrayList<>();
        stringList.add(truck.convertTruckToLine());

        ReadWriteFile.writeFile(FILE_VEHICLE, stringList, true);
    }

    @Override
    public void writeFile(List<Truck> list) {
        List<String> stringList = new ArrayList<>();
        for (Truck truck : list) {
            String line = truck.convertTruckToLine();
            stringList.add(line);
        }

        ReadWriteFile.writeFile(FILE_VEHICLE, stringList, true);
    }


    @Override
    public List<Truck> getVehicles() {
        List<String> stringList = ReadWriteFile.readFile(FILE_VEHICLE);
        List<Truck> truckList = new ArrayList<>();

        for (String line : stringList) {
            String[] array = line.split(",");
            if (array[0].equals("Xe tải:")) {
                String licensePlate = array[1];
                String manufacturerId = array[2];
                int year = Integer.parseInt(array[5]);
                String owner = array[6];
                double loadCapacity = Double.parseDouble(array[7]);

                Manufacturer manufacturer = manufacturerRepository.getById(manufacturerId);
                Truck truck = new Truck(licensePlate, manufacturer, year, owner, loadCapacity);
                truckList.add(truck);
            }
        }
        return truckList;
    }

    @Override
    public Truck getByLicensePlate(String licensePlate) {
        List<Truck> truckList = getVehicles();
        for (Truck truck : truckList) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                return truck;
            }
        }
        return null;
    }

    @Override
    public void delete(Truck truck) {
        List<String> stringList = ReadWriteFile.readFile(FILE_VEHICLE);
        List<String> updateList = new ArrayList<>();
        for (String line : stringList) {
            String[] array = line.split(",");
            if (array[0].equals("Xe tải:") && array[1].equals(truck.getLicensePlate())) {
                continue;
            }
            updateList.add(line);
        }
        ReadWriteFile.writeFile(FILE_VEHICLE, updateList, false);
    }

    @Override
    public List<Truck> searchLicensePlate(String licensePlate) {
        List<Truck> truckList = getVehicles();
        List<Truck> result = new ArrayList<>();

        for (Truck truck : truckList) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                result.add(truck);
            }
        }
        return result;
    }
}
