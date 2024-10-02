package quan_ly_khach_hang.repository;

import quan_ly_khach_hang.model.Customer;

import java.util.List;

public interface ICustomerRipository {
    List<Customer> getAll();

    void writeFileCustomer(List<Customer> customers);

    void add(Customer customer);

    void delete(Customer customer);

    Customer findByID(int id);

    List<Customer> searchName(String name);

    List<Customer> sortName();

    boolean edit(Customer editCustomer);

    List<Customer> sortId();


}
