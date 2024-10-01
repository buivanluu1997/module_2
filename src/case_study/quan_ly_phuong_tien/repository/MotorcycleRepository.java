package case_study.quan_ly_phuong_tien.repository;

import case_study.quan_ly_phuong_tien.model.Manufacturer;
import case_study.quan_ly_phuong_tien.model.Motorcycle;
import case_study.quan_ly_phuong_tien.service.FileHelper;


import java.util.ArrayList;
import java.util.List;

public class MotorcycleRepository implements IVehicleRepository<Motorcycle> {

    private List<Motorcycle> motorcycleList;
    private ManufacturerRepository manufacturerRepository = new ManufacturerRepository();
    private FileHelper fileHelper = new FileHelper();

    public MotorcycleRepository() {
        this.motorcycleList = new ArrayList<>();
    }

    @Override
    public void addVehicle(Motorcycle motorcycle) {
        motorcycleList.add(motorcycle);
    }

    @Override
    public List<Motorcycle> getVehicles() {
        return motorcycleList;
    }


    @Override
    public void delete(Motorcycle motorcycle) {
        motorcycleList.remove(motorcycle);
    }

    @Override
    public List<Motorcycle> searchLicensePlate(String licensePlate) {
        List<Motorcycle> result = new ArrayList<>();

        for (Motorcycle motorcycle : motorcycleList) {
            if (motorcycle.getLicensePlate().equals(licensePlate)) {
                result.add(motorcycle);
            }
        }
        return result;
    }

    @Override
    public void readFile() {
        String filePath = "D:\\codegym\\module2\\src\\case_study\\quan_ly_phuong_tien\\data\\output_motorcycle.txt";
        List<String> data =  fileHelper.readFile(filePath);
        for (String item : data){

            String [] cols = item.split(",");
            if(cols.length == 7 )
            {

                try {
                    String palate = cols[0];
                    String manufacturerId = cols[1];
                    int year = Integer.parseInt(cols[4]);
                    String owner = cols[5];
                    double power = Double.parseDouble(cols[6]);

                    Manufacturer manufacturer = manufacturerRepository.getById(manufacturerId);
                    Motorcycle motorcycle = new Motorcycle(palate,manufacturer,year,owner,power);
                    motorcycleList.add(motorcycle);
                }
                catch (NumberFormatException e)
                {

                }

            }

        }
    }

    @Override
    public void writeFile() {

        List <String> stringData = new ArrayList<>();

        for(Motorcycle motorcycle : motorcycleList) {
            String row =  "";
            row += motorcycle.getLicensePlate() + "," + motorcycle.getManufacturer().getManufacturerId() + ","
                    + motorcycle.getManufacturer().getManufacturerName() + ","
                    + motorcycle.getManufacturer().getCountry() + ","
                    + motorcycle.getYear() +","
                    + motorcycle.getOwner() +","
                    + motorcycle.getPower() ;
            stringData.add(row);
        }
        String path = "D:\\codegym\\module2\\src\\case_study\\quan_ly_phuong_tien\\data\\output_motorcycle.txt";
        this.fileHelper.writeFile(path,stringData);

    }


    @Override
    public Motorcycle getByLicensePlate(String licensePlate) {
        for (Motorcycle motorcycle : motorcycleList) {
            if (motorcycle.getLicensePlate().equals(licensePlate)) {
                return motorcycle;
            }
        }
        return null;
    }



}
