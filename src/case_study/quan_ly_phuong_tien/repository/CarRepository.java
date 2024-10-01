package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Car;
import case_study.quan_ly_phuong_tien.model.Manufacturer;
import case_study.quan_ly_phuong_tien.model.Motorcycle;
import case_study.quan_ly_phuong_tien.service.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class CarRepository implements IVehicleRepository<Car> {
    private List<Car> carList;
    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private FileHelper fileHelper = new FileHelper();

    public CarRepository() {
        this.carList = new ArrayList<>();
        carList.add(new Car("75A.25412", manufacturerRepository.manufacturerList.get(0), 2020, "Nguyễn Trọng Hoàng", 4, "Dịch vụ"));
    }

    @Override
    public void addVehicle(Car car) {
        carList.add(car);
    }

    @Override
    public List<Car> getVehicles() {
        return carList;
    }

    @Override
    public void delete(Car car) {
        carList.remove(car);
    }


    @Override
    public List<Car> searchLicensePlate(String licensePlate) {
        List<Car> result = new ArrayList<>();

        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate)) {
                result.add(car);
            }
        }
        return result;
    }

    @Override
    public void readFile() {
        String filePath = "D:\\codegym\\module2\\src\\case_study\\quan_ly_phuong_tien\\data\\output_car.txt";
        List<String> data =  fileHelper.readFile(filePath);
        for (String item : data){
            String [] cols = item.split(",");
            String palate = cols[0];
            String manufacturerId = cols[1];
            int year = Integer.parseInt(cols[4]);
            String owner = cols[5];
            int seatNumber = Integer.parseInt(cols[6]);
            String carType = cols[7];

            Manufacturer manufacturer = manufacturerRepository.getById(manufacturerId);
            Car car = new Car(palate,manufacturer,year,owner,seatNumber,carType);
            carList.add(car);
        }
    }

    @Override
    public void writeFile() {
        List<String> stringData = new ArrayList<>();
        for (Car car : carList) {
            String row = "";
            row += car.getLicensePlate() + "," + car.getManufacturer().getManufacturerId() + ","
                    + car.getManufacturer().getManufacturerName() + "," + car.getManufacturer().getCountry() + ","
                    + car.getYear() + "," + car.getOwner() + "," + car.getSeatNumber() + "," + car.getCarType();
            stringData.add(row);
        }
        String path = "D:\\codegym\\module2\\src\\case_study\\quan_ly_phuong_tien\\data\\output_car.txt";
        this.fileHelper.writeFile(path, stringData);
    }

    @Override
    public Car getByLicensePlate(String licensePlate) {
        for (Car car : carList) {
            if (car.getLicensePlate().equals(licensePlate)) {
                return car;
            }
        }
        return null;
    }

}
