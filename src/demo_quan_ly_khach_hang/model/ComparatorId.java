package demo_quan_ly_khach_hang.model;

import java.util.Comparator;

public class ComparatorId implements Comparator<Customer> {
    @Override
    public int compare(Customer o1, Customer o2) {
        return Integer.compare(o1.getId(), o2.getId());
    }
}
