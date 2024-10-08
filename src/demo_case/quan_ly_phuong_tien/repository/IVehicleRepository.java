package demo_case.quan_ly_phuong_tien.repository;

import java.util.List;

public interface IVehicleRepository<T> {
    void writeFile(List<T> list);

    List<T> findAll();

    void add(T entity);

    void delete(T entity);

    T findByLicensePlate(String licensePlate);

}
