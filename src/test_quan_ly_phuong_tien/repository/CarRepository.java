package test_quan_ly_phuong_tien.repository;

import test_quan_ly_phuong_tien.model.Car;
import test_quan_ly_phuong_tien.model.Manufacturer;
import test_quan_ly_phuong_tien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements IVehicleRepository<Car>{

    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private final String FILE_CAR_CSV = "src/test_quan_ly_phuong_tien/data/car.csv";

    @Override
    public void add(Car car) {
        List<Car> carList = getAll();
        carList.add(car);

        writeFileVehicle(carList);
    }

    @Override
    public List<Car> getAll() {
        List<Car> carList = new ArrayList<>();
        List<String> stringList = ReadWriteFile.readFile(FILE_CAR_CSV);
        for (String line : stringList) {
            String[] array = line.split(",");
            String licensePlate = array[0];
            String manufacturerId = array[1];
            int year = Integer.parseInt(array[4]);
            String owner = array[5];
            int seatNumber = Integer.parseInt(array[6]);
            String carType = array[7];
            Manufacturer manufacturer = manufacturerRepository.findById(manufacturerId);
            Car car = new Car(licensePlate, manufacturer, year, owner, seatNumber, carType);
            carList.add(car);
        }
        return carList;
    }

    @Override
    public void writeFileVehicle(List<Car> list) {
        List<String> stringList = new ArrayList<>();
        for (Car car : list) {
            String line = car.convertCarToLine();
            stringList.add(line);
        }
        ReadWriteFile.writeFile(FILE_CAR_CSV, stringList, false);
    }

    @Override
    public Car findLicensePlate(String licensePlate) {
        List<Car> carList = getAll();
        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void delete(Car car) {
        List<Car> carList = getAll();
        for (int i = 0; i < carList.size(); i++) {
            if (carList.get(i).getLicensePlate().equals(car.getLicensePlate())) {
                carList.remove(carList.get(i));
            }
        }

        writeFileVehicle(carList);
    }

    @Override
    public List<Car> search(String licensePlate) {
        List<Car> carList = getAll();
        List<Car> result = new ArrayList<>();
        for (Car car : carList) {
            if (car.getLicensePlate().toLowerCase().contains(licensePlate.toLowerCase())) {
                result.add(car);
            }
        }
        return result;
    }
}
