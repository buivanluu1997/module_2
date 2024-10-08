package demo_case.quan_ly_tien_dien.controller;

import demo_case.quan_ly_tien_dien.model.CustomerForeign;
import demo_case.quan_ly_tien_dien.service.CustomerForeignService;
import demo_case.quan_ly_tien_dien.service.ICustomerService;

import java.util.List;

public class CustomerForeignController {
    private ICustomerService<CustomerForeign> customerForeignService = new CustomerForeignService();
    public void addCustomer(CustomerForeign customer) {
        customerForeignService.addCustomer(customer);
    }

    public List<CustomerForeign> getAllCustomer() {
        return customerForeignService.getAllCustomer();
    }

    public CustomerForeign searchIdCustomer(String id) {
        return customerForeignService.searchIdCustomer(id);
    }

    public List<CustomerForeign> searchCustomerName(String name) {
        return customerForeignService.searchCustomerName(name);
    }
}
