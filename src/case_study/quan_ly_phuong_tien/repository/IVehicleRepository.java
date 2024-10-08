package case_study.quan_ly_phuong_tien.repository;

import java.util.List;

public interface IVehicleRepository<T> {

    void addVehicle(T object);

    void writeFile(List<T> list);

    List<T> getVehicles();

    T getByLicensePlate(String licensePlate);

    void delete(T object);

    List<T> searchLicensePlate(String licensePlate);


}
