package demo_case.quan_ly_tien_dien.repository;

import demo_case.quan_ly_tien_dien.model.CustomerForeign;
import demo_case.quan_ly_tien_dien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CustomerForeignRepository implements ICustomerRepository<CustomerForeign> {
    private final String FILE_CUSTOMER = "src/demo_case/quan_ly_tien_dien/data/customer.csv";

    @Override
    public void addCustomer(CustomerForeign customer) {
        List<String> stringList = new ArrayList<>();
        stringList.add(customer.convertCustomerForeignToLine());

       ReadWriteFile.writeFile(FILE_CUSTOMER, stringList, true);
    }

    @Override
    public List<CustomerForeign> getAllCustomer() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER);
        List<CustomerForeign> customerForeignList = new ArrayList<>();

        for (String line : stringList) {
            String[] arr = line.split(",");
            if (arr.length == 3) {
                customerForeignList.add(new CustomerForeign(arr[0], arr[1], arr[2]));
            }
        }
        return customerForeignList;
    }

    @Override
    public CustomerForeign searchIdCustomer(String id) {
       List<CustomerForeign> customerForeignList = getAllCustomer();
       for (CustomerForeign customerForeign : customerForeignList) {
           if (customerForeign.getCustomerCode().equals(id)) {
               return customerForeign;
           }
       }
       return null;
    }

    @Override
    public List<CustomerForeign> searchCustomerName(String name) {
        List<CustomerForeign> customerForeignList = getAllCustomer();
        List<CustomerForeign> result = new ArrayList<>();

        for (CustomerForeign customerForeign : customerForeignList) {
            if (customerForeign.getCustomerName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customerForeign);
            }
        }
        return result;
    }
}
