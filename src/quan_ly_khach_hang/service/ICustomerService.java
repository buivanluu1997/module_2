package quan_ly_khach_hang.service;

import quan_ly_khach_hang.model.Customer;

import java.util.List;

public interface ICustomerService {

    List<Customer> getAll();

    List<Customer> displayCustomer();

    void add(Customer customer);

    void delete(int id);

    Customer findByID(int id);

    List<Customer> searchName(String name);

    public List<Customer> sortName();

    boolean edit(Customer editCustomer);

    List<Customer> sortId();
}
