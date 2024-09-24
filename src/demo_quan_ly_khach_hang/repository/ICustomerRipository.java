package demo_quan_ly_khach_hang.repository;

import demo_quan_ly_khach_hang.model.Customer;

import java.util.List;

public interface ICustomerRipository {
    List<Customer> getAll();

    void add(Customer customer);

    void delete(int id);

    void search(String name);
}
