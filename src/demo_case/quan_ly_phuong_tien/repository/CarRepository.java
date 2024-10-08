package demo_case.quan_ly_phuong_tien.repository;

import demo_case.quan_ly_phuong_tien.model.Car;
import demo_case.quan_ly_phuong_tien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements IVehicleRepository<Car> {
    private final String FILE_CAR = "src/demo_case/quan_ly_phuong_tien/data/car.csv";

    @Override
    public void writeFile(List<Car> list) {
        List<String> stringList = new ArrayList<>();
        for (Car car : list) {
            stringList.add(car.csvCar());
        }
        ReadWriteFile.writeFile(FILE_CAR, stringList, false);
    }

    @Override
    public List<Car> findAll() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CAR);
        List<Car> carList = new ArrayList<>();
        for (String line : stringList) {
            String[] arr = line.split(",");
            String licensePlate = arr[0];
            String nameManufacturer = arr[1];
            int year = Integer.parseInt(arr[2]);
            String owner = arr[3];
            int numberSeats = Integer.parseInt(arr[4]);
            String carType = arr[5];

            Car car = new Car(licensePlate, nameManufacturer, year, owner, numberSeats, carType);
            carList.add(car);
        }
        return carList;
    }

    @Override
    public void add(Car entity) {
        List<Car> carList = findAll();
        carList.add(entity);

        writeFile(carList);
    }

    @Override
    public void delete(Car entity) {
        List<Car> carList = findAll();
        for (Car car : carList) {
            if (car.getLicensePlate().equals(entity.getLicensePlate())) {
                carList.remove(car);
                break;
            }
        }
        writeFile(carList);
    }

    @Override
    public Car findByLicensePlate(String licensePlate) {
        List<Car> carList = findAll();
        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }
}
