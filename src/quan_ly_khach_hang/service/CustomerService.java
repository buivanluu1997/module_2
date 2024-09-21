package quan_ly_khach_hang.service;

import quan_ly_khach_hang.model.Customer;
import quan_ly_khach_hang.repository.CustomerRipository;

public class CustomerService implements ICustomerService {
    private CustomerRipository customerRopository = new CustomerRipository();

    @Override
    public void getAll() {
        customerRopository.getAll();
    }

    @Override
    public void displayCustomer() {
        for (Customer customer : customerRopository.getAll()) {
            System.out.println(customer);
        }
    }

    @Override
    public void add(Customer customer) {
        customerRopository.add(customer);
    }

    @Override
    public void delete(int index) {
        customerRopository.delete(index);
    }

    @Override
    public void searchName(String name) {
        customerRopository.searchName(name);
    }

    @Override
    public void searchId(int id) {
        customerRopository.searchID(id);
    }


}
