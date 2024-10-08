package quan_ly_tien_dien.service;

import quan_ly_tien_dien.model.CustomerForeign;
import quan_ly_tien_dien.repository.ICustomerRepository;
import quan_ly_tien_dien.repository.CustomerForeignRepository;

import java.util.List;

public class CustomerForeignService implements ICustomerService<CustomerForeign> {
    private ICustomerRepository<CustomerForeign> customerForeignRepository = new CustomerForeignRepository();

    @Override
    public void addCustomer(CustomerForeign customerForeign) {
        customerForeignRepository.addCustomer(customerForeign);
    }

    @Override
    public List<CustomerForeign> getAllCustomer() {
        return customerForeignRepository.getAllCustomer();
    }

    @Override
    public CustomerForeign searchCustomerId(String customerId) {
        return customerForeignRepository.searchCustomerId(customerId);
    }

    @Override
    public List<CustomerForeign> searchNameCustomer(String name) {
        return customerForeignRepository.searchCustomerName(name);
    }
}
