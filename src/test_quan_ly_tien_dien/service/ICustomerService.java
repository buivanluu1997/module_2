package test_quan_ly_tien_dien.service;

import java.util.List;

public interface ICustomerService<T> {
    void add(T customer);

    List<T> findAll();

    T findById(String id);

    void delete(String id);

    List<T> findByName(String name);
}
