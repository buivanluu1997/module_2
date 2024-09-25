package demo_quan_ly_khach_hang.repository;

import demo_quan_ly_khach_hang.model.ComparatorId;
import demo_quan_ly_khach_hang.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRipository implements ICustomerRipository {
    private List<Customer> customersList;

    public CustomerRipository() {
        this.customersList = new ArrayList<>();
        customersList.add(new Customer(1, "Nguyen Van Anh", "Hue", "24555454161"));
        customersList.add(new Customer(3, "Tran Van Anh", "Da Nang", "3115662669"));
        customersList.add(new Customer(2, "Nguyen Van C", "Quang Tri", "5646496262"));
    }

    @Override
    public List<Customer> getAll() {
        return customersList;
    }

    @Override
    public void add(Customer customer) {
        customersList.add(customer);
    }

    @Override
    public void delete(int id) {
        int index = -1;
        for (int i = 0; i < customersList.size(); i++) {
            if (customersList.get(i).getId() == id) {
                index = i;
            }
        }
        customersList.remove(index);
    }

    @Override
    public void search(String name) {
        for (Customer customer : customersList) {
            if (customer.getName() != null && customer.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(customer);
            }
        }
    }

    @Override
    public List<Customer> sortID() {
        List<Customer> result;
        result = customersList;
        Collections.sort(result, new ComparatorId());
        return result;
    }
}
