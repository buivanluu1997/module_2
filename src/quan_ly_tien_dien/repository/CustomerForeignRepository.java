package quan_ly_tien_dien.repository;

import quan_ly_tien_dien.model.CustomerForeign;
import quan_ly_tien_dien.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;

public class CustomerForeignRepository implements ICustomerRepository<CustomerForeign> {

    private final String FILE_CUSTOMER = "src/quan_ly_tien_dien/data/customer.csv";

    @Override
    public void addCustomer(CustomerForeign customerForeign) {
        List<CustomerForeign> customerForeignList = getAllCustomer();
        customerForeignList.add(customerForeign);
        List<String> stringList = new ArrayList<>();
        stringList.add(customerForeign.convertForeignToLine());

        ReadWriteFile.writeFile(FILE_CUSTOMER, stringList, true);

    }

    @Override
    public List<CustomerForeign> getAllCustomer() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER);
        List<CustomerForeign> foreignList = new ArrayList<CustomerForeign>();

        for (String line : stringList) {
            String[] array = line.split(",");
            if (array.length == 3) {
                String customerCode = array[0];
                String name = array[1];
                String nationality = array[2];

                CustomerForeign customerForeign = new CustomerForeign(customerCode, name, nationality);
                foreignList.add(customerForeign);
            }
        }
        return foreignList;
    }

    @Override
    public CustomerForeign searchCustomerId(String customerId) {
        List<CustomerForeign> foreignList = getAllCustomer();
        for (CustomerForeign customerForeign : foreignList) {
            if (customerForeign.getCustomerCode().equals(customerId)) {
                return customerForeign;
            }
        }
        return null;
    }

    @Override
    public List<CustomerForeign> searchCustomerName(String name) {
        List<CustomerForeign> foreignList = getAllCustomer();
        List<CustomerForeign> searchNames = new ArrayList<>();

        for (CustomerForeign customerForeign : foreignList) {
            if (customerForeign.getName().toLowerCase().contains(name.toLowerCase())) {
                searchNames.add(customerForeign);
            }
        }
        return searchNames;
    }
}
