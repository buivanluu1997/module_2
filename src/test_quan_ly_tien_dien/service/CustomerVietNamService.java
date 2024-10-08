package test_quan_ly_tien_dien.service;

import test_quan_ly_tien_dien.model.CustomerVietNam;
import test_quan_ly_tien_dien.repository.CustomerVietNamRepository;
import test_quan_ly_tien_dien.repository.ICustomerRepository;

import java.util.List;

public class CustomerVietNamService implements ICustomerService<CustomerVietNam> {
    private ICustomerRepository<CustomerVietNam> vietNamRepository = new CustomerVietNamRepository();

    @Override
    public void add(CustomerVietNam customer) {
        vietNamRepository.add(customer);
    }

    @Override
    public List<CustomerVietNam> findAll() {
        return vietNamRepository.findAll();
    }

    @Override
    public CustomerVietNam findById(String id) {
        return vietNamRepository.findById(id);
    }

    @Override
    public void delete(String id) {
        vietNamRepository.delete(id);
    }

    @Override
    public List<CustomerVietNam> findByName(String name) {
        return vietNamRepository.findByName(name);
    }
}
