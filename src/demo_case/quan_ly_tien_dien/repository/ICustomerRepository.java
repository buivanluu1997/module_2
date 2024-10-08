package demo_case.quan_ly_tien_dien.repository;

import java.util.List;

public interface ICustomerRepository<T> {
    void addCustomer(T customer);

    List<T> getAllCustomer();

    T searchIdCustomer(String id);

    List<T> searchCustomerName(String name);
}
