package test_quan_ly_tien_dien.controller;

import test_quan_ly_tien_dien.model.CustomerVietNam;
import test_quan_ly_tien_dien.service.CustomerVietNamService;
import test_quan_ly_tien_dien.service.ICustomerService;

import java.util.List;

public class CustomerVietNamController {
    private ICustomerService<CustomerVietNam> vietNamService = new CustomerVietNamService();

    public void add(CustomerVietNam customer) {
        vietNamService.add(customer);
    }

    public List<CustomerVietNam> findAll() {
        return vietNamService.findAll();
    }

    public CustomerVietNam findById(String id) {
        return vietNamService.findById(id);
    }

    public void delete(String id) {
        vietNamService.delete(id);
    }

    public List<CustomerVietNam> findByName(String name) {
        return vietNamService.findByName(name);
    }
}
