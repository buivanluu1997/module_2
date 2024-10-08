package test_quan_ly_tien_dien.repository;

import test_quan_ly_phuong_tien.util.ReadWriteFile;
import test_quan_ly_tien_dien.model.CustomerVietNam;

import java.util.ArrayList;
import java.util.List;

public class CustomerVietNamRepository implements ICustomerRepository<CustomerVietNam>{
    private final String FILE_CUSTOMER = "src/test_quan_ly_tien_dien/data/customer.csv";


    @Override
    public void add(CustomerVietNam customer) {
        List<String> customerVietNamList = new ArrayList<>();
        customerVietNamList.add(customer.csvCustomerVietNam());

        ReadWriteFile.writeFile(FILE_CUSTOMER, customerVietNamList, true);
    }

    @Override
    public List<CustomerVietNam> findAll() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER);
        List<CustomerVietNam> customerVietNamList = new ArrayList<>();

        for (String line : stringList) {
            String[] arr = line.split(",");
            if (arr.length == 4) {
                String customerId = arr[0];
                String customerName = arr[1];
                String customerType = arr[2];
                int norm = Integer.parseInt(arr[3]);

                CustomerVietNam customerVietNam = new CustomerVietNam(customerId, customerName, customerType, norm);
                customerVietNamList.add(customerVietNam);
            }
        }
        return customerVietNamList;
    }

    @Override
    public CustomerVietNam findById(String id) {
       List<CustomerVietNam> customerVietNamList = findAll();
       for (CustomerVietNam customerVietNam : customerVietNamList) {
           if (customerVietNam.getCustomerId().equals(id)) {
               return customerVietNam;
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
            if (arr.length == 4 && arr[0].equals(id)) {
                continue;
            }
            newList.add(line);
        }
        ReadWriteFile.writeFile(FILE_CUSTOMER, newList, false);
    }

    @Override
    public List<CustomerVietNam> findByName(String name) {
        List<CustomerVietNam> customerVietNamList = findAll();
        List<CustomerVietNam> result = new ArrayList<>();

        for (CustomerVietNam customerVietNam : customerVietNamList) {
            if (customerVietNam.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customerVietNam);
            }
        }
        return result;
    }
}
