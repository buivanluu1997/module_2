package demo_case.quan_ly_tien_dien.controller;

import demo_case.quan_ly_tien_dien.model.CustomerVietNam;
import demo_case.quan_ly_tien_dien.repository.CustomerVietNamRepository;
import demo_case.quan_ly_tien_dien.repository.ICustomerRepository;
import demo_case.quan_ly_tien_dien.service.CustomerVietNamService;
import demo_case.quan_ly_tien_dien.service.ICustomerService;

import java.util.List;

public class CustomerVietNamController {
    private ICustomerService<CustomerVietNam> customerVietNamService = new CustomerVietNamService();

    public void addCustomer(CustomerVietNam customer) {
        customerVietNamService.addCustomer(customer);
    }

    public List<CustomerVietNam> getAllCustomer() {
        return customerVietNamService.getAllCustomer();
    }

    public CustomerVietNam searchIdCustomer(String id) {
        return customerVietNamService.searchIdCustomer(id);
    }

    public List<CustomerVietNam> searchCustomerName(String name) {
        return customerVietNamService.searchCustomerName(name);
    }
}
