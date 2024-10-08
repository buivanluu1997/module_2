package demo_case.quan_ly_tien_dien.service;

import demo_case.quan_ly_tien_dien.model.CustomerVietNam;
import demo_case.quan_ly_tien_dien.repository.CustomerVietNamRepository;
import demo_case.quan_ly_tien_dien.repository.ICustomerRepository;

import java.util.List;

public class CustomerVietNamService implements ICustomerService<CustomerVietNam> {
    private ICustomerRepository<CustomerVietNam> customerVietNamRepository = new CustomerVietNamRepository();

    @Override
    public void addCustomer(CustomerVietNam customer) {
        customerVietNamRepository.addCustomer(customer);
    }

    @Override
    public List<CustomerVietNam> getAllCustomer() {
        return customerVietNamRepository.getAllCustomer();
    }

    @Override
    public CustomerVietNam searchIdCustomer(String id) {
        return customerVietNamRepository.searchIdCustomer(id);
    }

    @Override
    public List<CustomerVietNam> searchCustomerName(String name) {
        return customerVietNamRepository.searchCustomerName(name);
    }
}
