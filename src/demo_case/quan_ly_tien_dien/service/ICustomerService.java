package demo_case.quan_ly_tien_dien.service;

import java.util.List;

public interface ICustomerService<T> {
    void addCustomer(T customer);

    List<T> getAllCustomer();

    T searchIdCustomer(String id);

    List<T> searchCustomerName(String name);
}
