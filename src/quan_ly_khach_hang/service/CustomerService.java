package quan_ly_khach_hang.service;

import quan_ly_khach_hang.model.Customer;
import quan_ly_khach_hang.repository.CustomerRopository;

import java.util.List;

public class CustomerService {
    private CustomerRopository customerRopository = new CustomerRopository();

    public void displayCustomer() {
        for (Customer customer : customerRopository.getAll()) {
            System.out.println(customer);
        }
    }

    public void add(Customer customer) {
        customerRopository.add(customer);
    }

    public void delete(int index) {
        customerRopository.delete(index);
    }

    public void searchName(String name) {
        customerRopository.SearchName(name);
    }
}
