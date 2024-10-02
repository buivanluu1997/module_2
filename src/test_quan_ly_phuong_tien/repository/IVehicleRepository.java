package test_quan_ly_phuong_tien.repository;

import quan_ly_khach_hang.model.Customer;

import java.util.List;

public interface IVehicleRepository<T> {
    void add(T object);

    List<T> getAll();

    void writeFileCustomer(List<T> list);

    T findLicensePlate(String licensePlate);

    void delete(T object);

    List<T> search(String licensePlate);
}
