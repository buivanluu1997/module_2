package quan_ly_khach_hang.service;

import quan_ly_khach_hang.model.Customer;

public interface ICustomerService {
    public void getAll();

    public void displayCustomer();

    public void add(Customer customer);

    public void delete(int index);

    public void searchName(String name);

    public void searchId(int id);
}
