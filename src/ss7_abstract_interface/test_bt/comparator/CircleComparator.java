package ss7_abstract_interface.test_bt.comparator;

import ss7_abstract_interface.test_bt.cac_loai_hinh.Circle;

import java.util.Collection;
import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        if (o1.getRadius() > o2.getRadius()) {
            return 1;
        } else if (o1.getRadius() < o2.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
