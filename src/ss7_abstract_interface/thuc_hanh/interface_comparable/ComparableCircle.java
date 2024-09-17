package ss7_abstract_interface.thuc_hanh.interface_comparable;

import ss6_tinh_ke_thua.thuc_hanh.Circle;
import ss7_abstract_interface.thuc_hanh.interface_comparator.CircleComparator;

public class ComparableCircle extends Circle implements Comparable<ComparableCircle>{
    public ComparableCircle() {

    }
    public ComparableCircle(double radius){
        super(radius);
    }
    public ComparableCircle(double radius, String color, boolean filled) {
        super(radius, color, filled);
    }

    @Override
    public int compareTo(ComparableCircle o) {
        if (getRadius() > o.getRadius()) {
            return 1;
        } else if (getRadius() < o.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
