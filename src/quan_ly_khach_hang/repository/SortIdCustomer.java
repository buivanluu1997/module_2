package quan_ly_khach_hang.repository;

import quan_ly_khach_hang.model.Customer;

import java.util.Comparator;

public class SortIdCustomer implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return Integer.compare(o2.getId(), o1.getId());
    }
}
