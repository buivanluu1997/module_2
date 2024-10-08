package test_quan_ly_tien_dien.repository;

import test_quan_ly_tien_dien.model.CustomerType;
import test_quan_ly_tien_dien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CustomerTypeRepository {
    private final String FILE_CUSTOMER_TYPE = "src/test_quan_ly_tien_dien/data/customer_type.csv";

    public List<CustomerType> getCustomerTypes() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER_TYPE);
        List<CustomerType> customerTypeList = new ArrayList<CustomerType>();

        for(String line : stringList){
            String[] arr = line.split(",");
            String id = arr[0];
            String name = arr[1];
            System.out.println(name);
            CustomerType customerType = new CustomerType(id, name);
            customerTypeList.add(customerType);
        }
        return customerTypeList;
    }
}
