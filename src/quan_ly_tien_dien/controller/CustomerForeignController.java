package quan_ly_tien_dien.controller;

import quan_ly_tien_dien.model.CustomerForeign;
import quan_ly_tien_dien.service.ICustomerService;
import quan_ly_tien_dien.service.CustomerForeignService;

import java.util.List;

public class CustomerForeignController {
    private ICustomerService<CustomerForeign> customerForeignService = new CustomerForeignService();

    public void addCustomer(CustomerForeign customerForeign) {
        customerForeignService.addCustomer(customerForeign);
    }

    public List<CustomerForeign> getAllCustomer() {
        return customerForeignService.getAllCustomer();
    }

    public CustomerForeign SearchCustomerId(String maKhachHang) {
        return customerForeignService.searchCustomerId(maKhachHang);
    }

    public List<CustomerForeign> searchNameCustomer(String name) {
        return customerForeignService.searchNameCustomer(name);
    }
}
