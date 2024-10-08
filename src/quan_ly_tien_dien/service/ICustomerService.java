package quan_ly_tien_dien.service;

import java.util.List;

public interface ICustomerService<T> {
    void addCustomer(T customer);

    List<T> getAllCustomer();

    T searchCustomerId(String customerId);

    List<T> searchNameCustomer(String name);
}
