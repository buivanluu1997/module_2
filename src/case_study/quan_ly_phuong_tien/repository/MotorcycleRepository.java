package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Manufacturer;
import case_study.quan_ly_phuong_tien.model.Motorcycle;
import case_study.quan_ly_phuong_tien.util.ReadWriteFile;


import java.util.ArrayList;
import java.util.List;

public class MotorcycleRepository implements IVehicleRepository<Motorcycle> {

    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private final String FILE_VEHICLE = "src/case_study/quan_ly_phuong_tien/data/vehicle.csv";


    public MotorcycleRepository(){}

    @Override
    public void addVehicle(Motorcycle motorcycle) {

        List<String> stringList = new ArrayList<>();
        stringList.add(motorcycle.convertMotorcycleToLine());

        ReadWriteFile.writeFile(FILE_VEHICLE, stringList, true);
    }

    @Override
    public void writeFile(List<Motorcycle> list) {
        List<String> stringList = new ArrayList<>();
        for (Motorcycle motorcycle : list) {
            String line = motorcycle.convertMotorcycleToLine();
            stringList.add(line);
        }
        ReadWriteFile.writeFile(FILE_VEHICLE, stringList, false);
    }


    @Override
    public List<Motorcycle> getVehicles() {
        List<String> stringList = ReadWriteFile.readFile(FILE_VEHICLE);
        List<Motorcycle> motorcycleList = new ArrayList<>();
        for (String line : stringList) {
            String[] array = line.split(",");
            if (array[0].equals("Xe máy:")) {
                String licensePlate = array[1];
                String manufaturerId = array[2];
                int year = Integer.parseInt(array[5]);
                String owner = array[6];
                double power = Double.parseDouble(array[7]);
                Manufacturer manufacturer = manufacturerRepository.getById(manufaturerId);
                Motorcycle motorcycle = new Motorcycle(licensePlate, manufacturer, year, owner, power);
                motorcycleList.add(motorcycle);
            }
        }
        return motorcycleList;
    }

    @Override
    public Motorcycle getByLicensePlate(String licensePlate) {
        List<Motorcycle> motorcycleList = getVehicles();
        for (Motorcycle motorcycle : motorcycleList) {
            if (motorcycle.getLicensePlate().equals(licensePlate)) {
                return motorcycle;
            }
        }
        return null;
    }

    @Override
    public void delete(Motorcycle motorcycle) {
        List<String> stringList = ReadWriteFile.readFile(FILE_VEHICLE);
        List<String> updateList = new ArrayList<>();
        for (String line : stringList) {
            String[] array = line.split(",");
            if (array[0].equals("Xe máy:") && array[1].equals(motorcycle.getLicensePlate())) {
                continue;
            }
            updateList.add(line);
        }
        ReadWriteFile.writeFile(FILE_VEHICLE, updateList, false);
    }

    @Override
    public List<Motorcycle> searchLicensePlate(String licensePlate) {
        List<Motorcycle> motorcycleList = getVehicles();
        List<Motorcycle> result = new ArrayList<>();

        for (Motorcycle motorcycle : motorcycleList) {
            if (motorcycle.getLicensePlate().equals(licensePlate)) {
                result.add(motorcycle);
            }
        }
        return result;
    }
}
