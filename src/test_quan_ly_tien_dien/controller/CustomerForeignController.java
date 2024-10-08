package test_quan_ly_tien_dien.controller;

import test_quan_ly_tien_dien.model.CustomerForeign;
import test_quan_ly_tien_dien.service.CustomerForeignService;
import test_quan_ly_tien_dien.service.ICustomerService;

import java.util.List;

public class CustomerForeignController {
    private ICustomerService<CustomerForeign> foreignService = new CustomerForeignService();
    public void add(CustomerForeign customer) {
        foreignService.add(customer);
    }

    public List<CustomerForeign> findAll() {
        return foreignService.findAll();
    }

    public CustomerForeign findById(String id) {
        return foreignService.findById(id);
    }

    public void delete(String id) {
        foreignService.delete(id);
    }

    public List<CustomerForeign> findByName(String name) {
        return foreignService.findByName(name);
    }
}
