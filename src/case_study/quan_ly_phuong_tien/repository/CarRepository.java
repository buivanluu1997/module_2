package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Car;
import case_study.quan_ly_phuong_tien.model.Manufacturer;
import case_study.quan_ly_phuong_tien.model.Motorcycle;
import case_study.quan_ly_phuong_tien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements IVehicleRepository<Car> {

    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private final String FILE_VEHICLE = "src/case_study/quan_ly_phuong_tien/data/vehicle.csv";

    public CarRepository() {}

    @Override
    public void addVehicle(Car car) {
       List<String> stringList = new ArrayList<>();
       stringList.add(car.convertCarToLine());

       ReadWriteFile.writeFile(FILE_VEHICLE, stringList, true);
    }

    @Override
    public List<Car> getVehicles() {
        List<Car> carList = new ArrayList<>();
        List<String> stringList = ReadWriteFile.readFile(FILE_VEHICLE);
        for (String line : stringList) {
            String[] array = line.split(",");
            if (array[0].equals("Ô tô:")) {
                String licensePlate = array[1];
                String manufaturerId = array[2];
                int year = Integer.parseInt(array[5]);
                String owner = array[6];
                int seatNumber = Integer.parseInt(array[7]);
                String carType = array[8];
                Manufacturer manufacturer = manufacturerRepository.getById(manufaturerId);
                Car car = new Car(licensePlate, manufacturer, year, owner, seatNumber, carType);
                carList.add(car);
            }
        }
        return carList;
    }

    @Override
    public void delete(Car car) {

        List<String> stringList = ReadWriteFile.readFile(FILE_VEHICLE);
        List<String> updateList = new ArrayList<>();
        for (String line : stringList) {
            String[] array = line.split(",");
            if (array[0].equals("Ô tô:") && array[1].equals(car.getLicensePlate())) {
                continue;
            }
            updateList.add(line);
        }
        ReadWriteFile.writeFile(FILE_VEHICLE, updateList, false);
    }

    @Override
    public List<Car> searchLicensePlate(String licensePlate) {
        List<Car> carList = getVehicles();
        List<Car> result = new ArrayList<>();

        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate)) {
                result.add(car);
            }
        }
        return result;
    }


    @Override
    public void writeFile(List<Car> carList) {
        List<String> stringData = new ArrayList<>();
        for (Car car : carList) {
            String line = car.convertCarToLine();
            stringData.add(line);
        }

        ReadWriteFile.writeFile(FILE_VEHICLE, stringData, true);
    }

    @Override
    public Car getByLicensePlate(String licensePlate) {
        List<Car> carList = getVehicles();
        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

}
