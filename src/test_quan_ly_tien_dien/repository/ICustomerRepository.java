package test_quan_ly_tien_dien.repository;

import java.util.List;

public interface ICustomerRepository<T> {
    void add(T customer);

    List<T> findAll();

    T findById(String id);

    void delete(String id);

    List<T> findByName(String name);
}
