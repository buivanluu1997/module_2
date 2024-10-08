package test_quan_ly_tien_dien.service;

import test_quan_ly_tien_dien.model.CustomerForeign;
import test_quan_ly_tien_dien.repository.CustomerForeignRepository;
import test_quan_ly_tien_dien.repository.ICustomerRepository;

import java.util.List;

public class CustomerForeignService implements ICustomerService<CustomerForeign> {
    private ICustomerRepository<CustomerForeign> foreignRepository = new CustomerForeignRepository();

    @Override
    public void add(CustomerForeign customer) {
        foreignRepository.add(customer);
    }

    @Override
    public List<CustomerForeign> findAll() {
        return foreignRepository.findAll();
    }

    @Override
    public CustomerForeign findById(String id) {
        return foreignRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        foreignRepository.delete(id);
    }

    @Override
    public List<CustomerForeign> findByName(String name) {
        return foreignRepository.findByName(name);
    }
}
