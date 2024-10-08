package test_quan_ly_tien_dien.repository;

import test_quan_ly_phuong_tien.util.ReadWriteFile;
import test_quan_ly_tien_dien.model.CustomerForeign;

import java.util.ArrayList;
import java.util.List;

public class CustomerForeignRepository implements ICustomerRepository<CustomerForeign> {
    private final String FILE_CUSTOMER = "src/test_quan_ly_tien_dien/data/customer.csv";

    @Override
    public void add(CustomerForeign customer) {
       List<String> customerForeignList = new ArrayList<>();
       customerForeignList.add(customer.csvCustomerForeign());

       ReadWriteFile.writeFile(FILE_CUSTOMER, customerForeignList, true);
    }


    @Override
    public List<CustomerForeign> findAll() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER);
        List<CustomerForeign> customerForeignList = new ArrayList<>();
        for (String line : stringList) {
            String[] arr = line.split(",");
            if (arr.length == 3) {
                String customerId = arr[0];
                String customerName = arr[1];
                String country = arr[2];

                CustomerForeign customerForeign = new CustomerForeign(customerId, customerName, country);
                customerForeignList.add(customerForeign);
            }
        }
        return customerForeignList;
    }

    @Override
    public CustomerForeign findById(String id) {
        List<CustomerForeign> customerForeignList = findAll();
        for (CustomerForeign customerForeign : customerForeignList) {
            if (customerForeign.getCustomerId().equals(id)) {
                return customerForeign;
            }
        }
        return null;
    }

    @Override
    public void delete(String id) {
        List<String> list = ReadWriteFile.readFile(FILE_CUSTOMER);
        List<String> newList = new ArrayList<>();
        for (String line : list) {
            String[] arr = line.split(",");
            if (arr.length == 3 && arr[0].equals(id)) {
                continue;
            }
            newList.add(line);
        }
        ReadWriteFile.writeFile(FILE_CUSTOMER, newList, false);
    }

    @Override
    public List<CustomerForeign> findByName(String name) {
        List<CustomerForeign> customerForeignList = findAll();
        List<CustomerForeign> result = new ArrayList<>();

        for (CustomerForeign customerForeign : customerForeignList) {
            if (customerForeign.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customerForeign);
            }
        }
        return result;
    }
}
