package quan_ly_tien_dien.service;

import quan_ly_tien_dien.model.CustomerVietNam;
import quan_ly_tien_dien.repository.ICustomerRepository;
import quan_ly_tien_dien.repository.CustomerVietNamRepository;

import java.util.List;

public class CustomerVietNamService implements ICustomerService<CustomerVietNam> {
    private ICustomerRepository<CustomerVietNam> customerVietNamRepository = new CustomerVietNamRepository();

    @Override
    public void addCustomer(CustomerVietNam customerVietNam) {
        customerVietNamRepository.addCustomer(customerVietNam);
    }

    @Override
    public List<CustomerVietNam> getAllCustomer() {
        return customerVietNamRepository.getAllCustomer();
    }

    @Override
    public CustomerVietNam searchCustomerId(String customerId) {
        return customerVietNamRepository.searchCustomerId(customerId);
    }

    @Override
    public List<CustomerVietNam> searchNameCustomer(String name) {
        return customerVietNamRepository.searchCustomerName(name);
    }
}
