package demo_case.quan_ly_phuong_tien.service;

import java.util.List;

public interface IVehicleService<T> {
    List<T> findAll();

    void add(T entity);

    void delete(T entity);

    T findByLicensePlate(String licensePlate);
}
