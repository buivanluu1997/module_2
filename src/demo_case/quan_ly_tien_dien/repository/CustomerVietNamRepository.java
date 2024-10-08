package demo_case.quan_ly_tien_dien.repository;

import demo_case.quan_ly_tien_dien.model.CustomerType;
import demo_case.quan_ly_tien_dien.model.CustomerVietNam;
import demo_case.quan_ly_tien_dien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CustomerVietNamRepository implements ICustomerRepository<CustomerVietNam> {
    private final String FILE_CUSTOMER = "src/demo_case/quan_ly_tien_dien/data/customer.csv";

    @Override
    public void addCustomer(CustomerVietNam customer) {
        List<String> stringList = new ArrayList<>();
        stringList.add(customer.convertCustomerVietNamToLine());

        ReadWriteFile.writeFile(FILE_CUSTOMER, stringList,true);
    }

    @Override
    public List<CustomerVietNam> getAllCustomer() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER);
        List<CustomerVietNam> customerVietNamList = new ArrayList<>();

        for (String line : stringList) {
            String[] arr = line.split(",");
            if (arr.length == 5) {
                String customerCode = arr[0];
                String customerName = arr[1];
                String customerTypeId = arr[2];
                double norm = Double.parseDouble(arr[4]);

                CustomerType customerType = CustomerTypeRepository.findIdCustomerType(customerTypeId);
                CustomerVietNam customerVietNam = new CustomerVietNam(customerCode, customerName, customerType, norm);
                customerVietNamList.add(customerVietNam);
            }
        }
        return customerVietNamList;
    }

    @Override
    public CustomerVietNam searchIdCustomer(String id) {
        List<CustomerVietNam> customerVietNamList = getAllCustomer();
        for (CustomerVietNam customerVietNam : customerVietNamList) {
            if (customerVietNam.getCustomerCode().equals(id)) {
                return customerVietNam;
            }
        }
        return null;
    }

    @Override
    public List<CustomerVietNam> searchCustomerName(String name) {
        List<CustomerVietNam> customerVietNamList = getAllCustomer();
        List<CustomerVietNam> result = new ArrayList<>();
        for (CustomerVietNam customerVietNam : customerVietNamList) {
            if (customerVietNam.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customerVietNam);
            }
        }
        return result;
    }
}
