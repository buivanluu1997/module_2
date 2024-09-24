package demo_quan_ly_khach_hang.service;

import demo_quan_ly_khach_hang.model.Customer;
import demo_quan_ly_khach_hang.repository.CustomerRipository;

import java.util.List;

public class CustomerService implements ICustomerService{
    private CustomerRipository customerRipository = new CustomerRipository();

    @Override
    public List<Customer> getAll() {
        return customerRipository.getAll();
    }

    @Override
    public void display() {
        for (Customer customer : customerRipository.getAll()) {
            if (customerRipository.getAll() != null) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public void add(Customer customer) {
        customerRipository.add(customer);
    }

    @Override
    public void delete(int id) {
        customerRipository.delete(id);
    }

    @Override
    public void search(String name) {
        customerRipository.search(name);
    }
}
