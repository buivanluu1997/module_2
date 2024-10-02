package test_quan_ly_phuong_tien.repository;

import test_quan_ly_phuong_tien.model.Manufacturer;
import test_quan_ly_phuong_tien.model.Motorcycle;
import test_quan_ly_phuong_tien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class MotorcycleRepository implements IVehicleRepository<Motorcycle>{

    private ManufacturerRepository manufactureRepository = new ManufacturerRepository();
    private final String FILE_CAR_CSV = "src/test_quan_ly_phuong_tien/data/motorcycle.csv";

    @Override
    public void add(Motorcycle motorcycle) {
        List<Motorcycle> motorcycleList = getAll();
        motorcycleList.add(motorcycle);

        writeFileVehicle(motorcycleList);
    }

    @Override
    public List<Motorcycle> getAll() {
        List<Motorcycle> motorcycleList = new ArrayList<>();
        List<String> stringList = ReadWriteFile.readFile(FILE_CAR_CSV);
        for (String line : stringList) {
            String[] array = line.split(",");
            String licensePlate = array[0];
            String manufacturerId = array[1];
            int year = Integer.parseInt(array[4]);
            String owner = array[5];
            double power = Double.parseDouble(array[6]);

            Manufacturer manufacturer = manufactureRepository.findById(manufacturerId);
            Motorcycle motorcycle = new Motorcycle(licensePlate, manufacturer, year, owner, power);

            motorcycleList.add(motorcycle);
        }
        return motorcycleList;
    }

    @Override
    public void writeFileVehicle(List<Motorcycle> list) {
        List<String> stringList = new ArrayList<>();
        for (Motorcycle motorcycle : list) {
            String line = motorcycle.convertMotorcycleToLine();
            stringList.add(line);
        }
        ReadWriteFile.writeFile(FILE_CAR_CSV, stringList, false);
    }

    @Override
    public Motorcycle findLicensePlate(String licensePlate) {
        List<Motorcycle> motorcycleList = getAll();
        for (int i = 0; i < motorcycleList.size(); i++) {
            if (motorcycleList.get(i).getLicensePlate().equals(licensePlate)) {
                return motorcycleList.get(i);
            }
        }
        return null;
    }

    @Override
    public void delete(Motorcycle motorcycle) {
        List<Motorcycle> motorcycleList = getAll();
        for (int i = 0; i < motorcycleList.size(); i++) {
            if (motorcycleList.get(i).getLicensePlate().equals(motorcycle.getLicensePlate())) {
                motorcycleList.remove(i);
            }
        }
        writeFileVehicle(motorcycleList);
    }

    @Override
    public List<Motorcycle> search(String licensePlate) {
        List<Motorcycle> motorcycleList = getAll();
        List<Motorcycle> result = new ArrayList<>();

        for (Motorcycle motorcycle : motorcycleList) {
            if (motorcycle.getLicensePlate().equals(licensePlate)) {
                result.add(motorcycle);
            }
        }
        return result;
    }
}
