package quan_ly_tien_dien.controller;

import quan_ly_tien_dien.model.CustomerVietNam;
import quan_ly_tien_dien.service.ICustomerService;
import quan_ly_tien_dien.service.CustomerVietNamService;

import java.util.List;

public class CustomerVietNamController {
    private ICustomerService<CustomerVietNam> customerVietNamService = new CustomerVietNamService();

    public void addCustomer(CustomerVietNam customerVietNam) {
        customerVietNamService.addCustomer(customerVietNam);
    }

    public List<CustomerVietNam> getAllCustomer() {
        return customerVietNamService.getAllCustomer();
    }

    public CustomerVietNam searchCustomerId(String customerId) {
        return customerVietNamService.searchCustomerId(customerId);
    }

    public List<CustomerVietNam> searchNameCustomer(String name){
        return customerVietNamService.searchNameCustomer(name);
    }
}
