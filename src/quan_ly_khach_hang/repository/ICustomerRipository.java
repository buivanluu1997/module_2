package quan_ly_khach_hang.repository;

import quan_ly_khach_hang.model.Customer;

import java.util.List;

public interface ICustomerRipository {
     List<Customer> getAll();

     List<Customer> displayCustomer();

     void add(Customer customer);

     void delete(int id);

     Customer findByID(int id);

     List<Customer> searchName(String name);

     List<Customer> sortName();

     boolean edit(Customer editCustomer);

     List<Customer> sortId();
}
