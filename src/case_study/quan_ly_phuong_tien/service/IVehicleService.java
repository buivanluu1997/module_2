package case_study.quan_ly_phuong_tien.service;

import java.util.List;

public interface IVehicleService<T> {
    void addVehicle(T object);

    List<T> getVehicles();

    T getByLicensePlate(String licensePlate);

    void delete(T object);

    List<T> searchLicensePlate(String licensePlate);

    void readFile();

    void writeFile();

}
