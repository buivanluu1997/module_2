package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Manufacturer;
import case_study.quan_ly_phuong_tien.model.Truck;
import case_study.quan_ly_phuong_tien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements IVehicleRepository<Truck> {

    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private final String FILE_VEHICLE = "src/case_study/quan_ly_phuong_tien/data/vehicle.csv";

    @Override
    public void addVehicle(Truck object) {
        List<Truck> truckList = getVehicles();
        truckList.add(object);

        writeFile(truckList);
    }

    @Override
    public void writeFile(List<Truck> list) {
        List<String> stringList = new ArrayList<>();
        for (Truck truck : list) {
            String line = truck.convertTruckToLine();
            stringList.add(line);
        }

        ReadWriteFile.writeFile(FILE_VEHICLE, stringList, false);
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
    public void delete(Truck object) {
        List<Truck> truckList = getVehicles();
        for (int i = 0; i < truckList.size(); i++) {
            if (truckList.get(i).getLicensePlate().equals(object.getLicensePlate())) {
                truckList.remove(i);
            }
        }
        writeFile(truckList);
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
