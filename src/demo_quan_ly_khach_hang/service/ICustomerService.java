package demo_quan_ly_khach_hang.service;

import demo_quan_ly_khach_hang.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> getAll();

    void display();

    void add(Customer customer);

    void delete(int id);

    void search(String name);
    List<Customer> sortID();

}
