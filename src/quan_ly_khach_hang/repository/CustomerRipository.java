package quan_ly_khach_hang.repository;

import quan_ly_khach_hang.model.Customer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRipository implements ICustomerRipository {
    private List<Customer> customerList;

    public CustomerRipository() {
        this.customerList = new ArrayList<>();
        customerList.add(new Customer(1, "Nguyễn Ngọc Nhân", "Đà Nẵng", "0984512425"));
        customerList.add(new Customer(4, "Nguyễn Như Ngọc", "Huế", "021547850"));
        customerList.add(new Customer(3, "Lê Văn Hoàng", "Quảng Nam", "0968745213"));
        customerList.add(new Customer(2, "Hồ Yến Nhi", "Quảng Trị", "0587451235"));
    }


    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    @Override
    public List<Customer> displayCustomer() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                customerList.remove(i);
                break;
            }
        }
    }

    @Override
    public Customer findByID(int id) {
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> searchName(String name) {
        List<Customer> result = new ArrayList<>();

        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customer);
            }
        }
        return result;
    }

    @Override
    public List<Customer> sortName() {
        List<Customer> customers = customerList;
        Collections.sort(customers);
        return customers;
    }

    @Override
    public boolean edit(Customer editCustomer) {
        for (Customer customer : customerList) {
            if (customer.getId() == editCustomer.getId()) {
                customer.setName(editCustomer.getName());
                customer.setAddress(editCustomer.getAddress());
                customer.setPhoneNumber(editCustomer.getPhoneNumber());
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Customer> sortId() {
       List<Customer> result = new ArrayList<>();
       result = customerList;
       SortIdCustomer sortIdCustomer = new SortIdCustomer();
       Collections.sort(result, sortIdCustomer);
       return result;
    }


}
