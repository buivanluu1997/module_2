package quan_ly_khach_hang.repository;

import quan_ly_khach_hang.model.Customer;

import java.util.List;

public interface ICustomerRipository {
    public List<Customer> getAll();

    public void add(Customer customer);

    public void delete(int id);

    public void searchName(String name);

    public void searchID(int id);
}
