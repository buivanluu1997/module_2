package demo_case.quan_ly_tien_dien.repository;

import demo_case.quan_ly_tien_dien.model.CustomerType;
import demo_case.quan_ly_tien_dien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository {
    private static final String FILE_CUSTOMER_TYPE = "src/demo_case/quan_ly_tien_dien/data/CustomerType";

    public static List<CustomerType> getAllCustomerType() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER_TYPE);
        List<CustomerType> customerTypeList = new ArrayList<CustomerType>();

        for (String line : stringList) {
            String[] arr = line.split(",");
            String id = arr[0];
            String type = arr[1];
            CustomerType customerType = new CustomerType(id, type);
            customerTypeList.add(customerType);
        }
        return customerTypeList;
    }

    public static CustomerType findIdCustomerType(String id) {
        List<CustomerType> customerTypeList = getAllCustomerType();
        for (CustomerType customerType : customerTypeList) {
            if (id.equals(customerType.getId())) {
                return customerType;
            }
        }
        return null;
    }
}
