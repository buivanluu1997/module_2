package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Manufacturer;
import case_study.quan_ly_phuong_tien.model.Truck;
import case_study.quan_ly_phuong_tien.service.FileHelper;

import java.util.ArrayList;
import java.util.List;

public class TruckRepository implements IVehicleRepository<Truck> {

    private List<Truck> truckList;
    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private FileHelper fileHelper = new FileHelper();

    public TruckRepository() {
        this.truckList = new ArrayList<>();
        truckList.add(new Truck("75C.25252", manufacturerRepository.manufacturerList.get(1), 2019, "Trần Thành Trung", 3.5));
    }

    @Override
    public void addVehicle(Truck object) {
        truckList.add(object);
    }

    @Override
    public List<Truck> getVehicles() {
        return truckList;
    }

    @Override
    public void delete(Truck truck) {
        truckList.remove(truck);
    }

    @Override
    public List<Truck> searchLicensePlate(String licensePlate) {
        List<Truck> result = new ArrayList<>();

        for (Truck truck : truckList) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                result.add(truck);
            }
        }
        return result;
    }

    @Override
    public void readFile() {
        String path = "D:\\codegym\\module2\\src\\case_study\\quan_ly_phuong_tien\\data\\output_truck";
        List<String> stringData = this.fileHelper.readFile(path);
        for (String item : stringData) {
            String[] cols = item.split(",");
            String licensePlate = cols[0];
            String manufacturerId = cols[1];
            int year = Integer.parseInt(cols[4]);
            String owner = cols[5];
            double loadCapacity = Double.parseDouble(cols[6]);

            Manufacturer manufacturer = manufacturerRepository.getById(manufacturerId);
            Truck truck = new Truck(licensePlate, manufacturer, year, owner, loadCapacity);
        }
    }

    @Override
    public void writeFile() {
        List<String> stringData = new ArrayList<>();
        for (Truck truck : truckList) {
            String row = "";
            row += truck.getLicensePlate() + "," + truck.getManufacturer().getManufacturerId() + ","
                    + truck.getManufacturer().getManufacturerName() + "," + truck.getManufacturer().getCountry() + ","
                    + truck.getYear() + "," + truck.getOwner() + "," + truck.getLoadCapacity();
            stringData.add(row);
        }
        String path = "D:\\codegym\\module2\\src\\case_study\\quan_ly_phuong_tien\\data\\output_truck";
        this.fileHelper.writeFile(path,stringData);
    }

    @Override
    public Truck getByLicensePlate(String licensePlate) {
        for (Truck truck : truckList) {
            if (truck.getLicensePlate().equals(licensePlate)) {
                return truck;
            }
        }
        return null;
    }

}
