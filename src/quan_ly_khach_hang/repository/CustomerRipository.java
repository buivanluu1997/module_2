package quan_ly_khach_hang.repository;

import quan_ly_khach_hang.model.Customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerRipository implements ICustomerRipository {
    private List<Customer> customerList;

    public CustomerRipository() {
        this.customerList = new ArrayList<>();
        customerList.add(new Customer(1,"Nguyễn Ngọc Nhân", "Đà Nẵng", "0984512425"));
        customerList.add(new Customer(2,"Nguyễn Như Ngọc", "Huế", "021547850"));
        customerList.add(new Customer(3,"Lê Văn Hoàng", "Quảng Nam", "0968745213"));
        customerList.add(new Customer(4,"Hồ Yến Nhi", "Quảng Trị", "0587451235"));
    }

    @Override
    public List<Customer> getAll() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public void delete(int id) {
        int index = -1;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == id) {
                index = i;
                break;
            }
        }
        customerList.remove(index);
    }

    @Override
    public void searchName(String name) {
        boolean check = false;
        for (Customer customer : customerList) {
            if (customer.getName() != null && customer.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(customer);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Tên tìm kiếm không có trong danh sách");
        }
    }

    @Override
    public void searchID(int id) {
        boolean check = false;
        for (Customer customer : customerList) {
            if (customer.getId() == id) {
                System.out.println(customer);
                check = true;
            }
        }
        if (!check) {
            System.out.println("Id không có trong danh sách");
        }
    }



}
