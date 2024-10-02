package quan_ly_khach_hang.repository;

import quan_ly_khach_hang.model.Customer;
import quan_ly_khach_hang.util.ReadWriteFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomerRipository implements ICustomerRipository {

    private final String FILE_CUSTOMER = "src/quan_ly_khach_hang/data/customer.csv";


    @Override
    public List<Customer> getAll() {
        List<String> stringList = ReadWriteFile.readFile(FILE_CUSTOMER);
        List<Customer> customers = new ArrayList<>();
        String[] array = null;
        for (String line : stringList) {
            array = line.split(",");
            int id = Integer.parseInt(array[0]);
            String name = array[1];
            String address = array[2];
            String phoneNumber = array[3];
            Customer customer = new Customer(id, name, address, phoneNumber);
            customers.add(customer);
        }
        return customers;
    }

    @Override
    public void add(Customer customer) {

        List<Customer> customers = getAll();
        customers.add(customer);

        writeFileCustomer(customers);
    }

    @Override
    public void delete(Customer customer) {
        List<Customer> customers = getAll();
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getId() == customer.getId()) {
                customers.remove(i);
                break;
            }
        }

        writeFileCustomer(customers);
    }
    @Override
    public void writeFileCustomer(List<Customer> customers) {
        List<String> stringList = new ArrayList<>();
        for (Customer customer1 : customers) {
            String cols = customer1.getId() + "," + customer1.getName() + "," + customer1.getAddress() + "," + customer1.getPhoneNumber();
            stringList.add(cols);
        }
        ReadWriteFile.writeFile(FILE_CUSTOMER, stringList, false);
    }

    @Override
    public Customer findByID(int id) {
        List<Customer> customers = getAll();
        for (Customer customer : customers) {
            if (customer.getId() == id) {
                return customer;
            }
        }
        return null;
    }

    @Override
    public List<Customer> searchName(String name) {
        List<Customer> customerList = getAll();
        List<Customer> result = new ArrayList<>();
        for (Customer customer : customerList) {
            if (customer.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(customer);
            }
        }
        return result;
    }

    @Override
    public List<Customer> sortName() {
        List<Customer> customers = getAll();
        Collections.sort(customers);
        writeFileCustomer(customers);
        return customers;
    }

    @Override
    public boolean edit(Customer editCustomer) {
        List<Customer> customerList = getAll();

        boolean isUpdate = false;

        for (Customer customer : customerList) {
            if (customer.getId() == editCustomer.getId()) {
                customer.setName(editCustomer.getName());
                customer.setAddress(editCustomer.getAddress());
                customer.setPhoneNumber(editCustomer.getPhoneNumber());
                isUpdate = true;
                break;
            }
        }

        if (isUpdate) {
            writeFileCustomer(customerList);
        }
        return isUpdate;
    }

    @Override
    public List<Customer> sortId() {
        List<Customer> result = getAll();
        SortIdCustomer sortIdCustomer = new SortIdCustomer();
        Collections.sort(result, sortIdCustomer);
        writeFileCustomer(result);
        return result;
    }

}
