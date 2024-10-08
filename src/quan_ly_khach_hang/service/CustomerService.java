package quan_ly_khach_hang.service;

import quan_ly_khach_hang.model.Customer;
import quan_ly_khach_hang.repository.CustomerRipository;

import java.util.List;

public class CustomerService implements ICustomerService {
    private CustomerRipository customerRopository = new CustomerRipository();


    @Override
    public List<Customer> getAll() {
        return customerRopository.getAll();
    }


    @Override
    public void add(Customer customer) {
        this.customerRopository.add(customer);
    }

    @Override
    public void delete(Customer customer) {
        customerRopository.delete(customer);
    }

    @Override
    public Customer findByID(int id) {
        return customerRopository.findByID(id);
    }

    @Override
    public List<Customer> searchName(String name) {
        return customerRopository.searchName(name);
    }

    @Override
    public List<Customer> sortName() {
        return customerRopository.sortName();
    }

    @Override
    public boolean edit(Customer editCustomer) {
        return customerRopository.edit(editCustomer);
    }

    @Override
    public List<Customer> sortId() {
        return customerRopository.sortId();
    }


}
