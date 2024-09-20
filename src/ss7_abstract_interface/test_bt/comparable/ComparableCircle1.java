package ss7_abstract_interface.test_bt.comparable;

import ss7_abstract_interface.test_bt.cac_loai_hinh.Circle;

public class ComparableCircle1 extends Circle implements Comparable<ComparableCircle1>{

    public ComparableCircle1(double radius) {
        super(radius);
    }

    public ComparableCircle1(String color, boolean filled, double radius) {
        super(color, filled, radius);
    }

    @Override
    public int compareTo(ComparableCircle1 o) {
        if (getRadius() > o.getRadius()) {
            return 1;
        } else if (getRadius() < o.getRadius()) {
            return -1;
        } else {
            return 0;
        }
    }
}
