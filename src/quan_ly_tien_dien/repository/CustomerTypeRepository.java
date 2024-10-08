package quan_ly_tien_dien.repository;

import quan_ly_tien_dien.model.CustomerType;
import quan_ly_tien_dien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository {
    private static final String FILE_CUSTOMER_TYPE = "src/quan_ly_tien_dien/data/customer_type.csv";

    public static List<CustomerType> customerTypeList() {
        List<CustomerType> customerTypeList = new ArrayList<>();
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER_TYPE);
        for (String line : stringList) {
            String[] arr = line.split(",");
            String id = arr[0];
            String type = arr[1];
            CustomerType customerType = new CustomerType(id, type);
            customerTypeList.add(customerType);
        }
        return customerTypeList;
    }

    public static CustomerType searchCustomerTypeId(String id) {
        List<CustomerType> list = customerTypeList();
        for (CustomerType customerType : list) {
            if (customerType.getId().equals(id)) {
                return customerType;
            }
        }
        return null;
    }
}
