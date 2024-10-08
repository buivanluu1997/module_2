package quan_ly_tien_dien.repository;

import quan_ly_tien_dien.model.CustomerVietNam;
import quan_ly_tien_dien.model.CustomerType;
import quan_ly_tien_dien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CustomerVietNamRepository implements ICustomerRepository<CustomerVietNam> {
    private final String FILE_CUSTOMER = "src/quan_ly_tien_dien/data/customer.csv";

    public CustomerVietNamRepository() {
    }

    @Override
    public void addCustomer(CustomerVietNam customerVietNam) {

        List<String> stringList = new ArrayList<>();
        stringList.add(customerVietNam.convertKHVNToLine());

        ReadWriteFile.writeFile(FILE_CUSTOMER, stringList, true);
    }

    @Override
    public List<CustomerVietNam> getAllCustomer() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER);
        List<CustomerVietNam> vietNamList = new ArrayList<>();

        for (String line : stringList) {
            String[] array = line.split(",");
            if (array.length == 5) {
                String customerCode = array[0];
                String name = array[1];
                String customerTypeCode = array[2];
                double norm = Double.parseDouble(array[4]);

                CustomerType customerType = CustomerTypeRepository.searchCustomerTypeId(customerTypeCode);

                CustomerVietNam customerVietNam = new CustomerVietNam(customerCode, name, customerType, norm);
                vietNamList.add(customerVietNam);
            }
        }
        return vietNamList;
    }

    @Override
    public CustomerVietNam searchCustomerId(String customerId) {
        List<CustomerVietNam> vietNamList = getAllCustomer();
        for (CustomerVietNam customerVietNam : vietNamList) {
            if (customerVietNam.getCustomerCode().equals(customerId)) {
                return customerVietNam;
            }
        }
        return null;
    }

    @Override
    public List<CustomerVietNam> searchCustomerName(String name) {
        List<CustomerVietNam> vietNamList = getAllCustomer();
        List<CustomerVietNam> searchNameVietNam = new ArrayList<>();

        for (CustomerVietNam customerVietNam : vietNamList) {
            if (customerVietNam.getName().toLowerCase().contains(name.toLowerCase())) {
                searchNameVietNam.add(customerVietNam);
            }
        }
        return searchNameVietNam;
    }
}
