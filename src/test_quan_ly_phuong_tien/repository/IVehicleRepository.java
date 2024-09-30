package test_quan_ly_phuong_tien.repository;

import java.util.List;

public interface IVehicleRepository<T> {
    void add(T object);

    List<T> getAll();

    T findLicensePlate(String licensePlate);

    void delete(T object);

    List<T> search(String licensePlate);
}
