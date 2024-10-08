package demo_case.quan_ly_tien_dien.service;

import demo_case.quan_ly_tien_dien.model.CustomerForeign;
import demo_case.quan_ly_tien_dien.repository.CustomerForeignRepository;
import demo_case.quan_ly_tien_dien.repository.ICustomerRepository;


import java.util.List;

public class CustomerForeignService implements ICustomerService<CustomerForeign> {
    private ICustomerRepository<CustomerForeign> customerForeignRepository = new CustomerForeignRepository();

    @Override
    public void addCustomer(CustomerForeign customer) {
        customerForeignRepository.addCustomer(customer);
    }

    @Override
    public List<CustomerForeign> getAllCustomer() {
        return customerForeignRepository.getAllCustomer();
    }

    @Override
    public CustomerForeign searchIdCustomer(String id) {
        return customerForeignRepository.searchIdCustomer(id);
    }

    @Override
    public List<CustomerForeign> searchCustomerName(String name) {
        return customerForeignRepository.searchCustomerName(name);
    }
}
